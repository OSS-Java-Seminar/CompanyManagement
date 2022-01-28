package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.entities.UserRole;
import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import com.CompanyManagement.service.EmployeeService;
import com.CompanyManagement.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@AllArgsConstructor
@Controller
@RequestMapping("/employees/")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("listOfEmployees")
    public String viewHomePage(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "employee-list";
    }
    @GetMapping("ShowNewEmployeeForm")
    public String showNewEmployeeForm(Employee employee) {
        return "new_employee";
    }

    @PostMapping("add")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "new_employee";
        }
        Employee employee1 = new Employee(employee.getEmployeeName(), employee.getSurname(), employee.getOib(), employee.getAddress(), employee.getEmail(), passwordEncoder.encode(employee.getPasswd()), null);
        employeeRepository.save(employee1);
        return "redirect:listOfEmployees";
    }

    @PostMapping("update/{id}")
    public String updateStudent(UserRole userRole, @PathVariable("id") UUID id, @Valid Employee employee, BindingResult result,
                                Model model) {
        Collection<UserRole> listRoles = employeeService.listRoles();
        if (result.hasErrors()) {
            employee.setId(id);
            return "update-employee";
        }

        employeeRepository.save(employee);
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("listRoles", listRoles);
        return "employee-list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(UserRole userRole, @PathVariable("id") UUID id, Model model) {
        Collection<UserRole> listRoles = employeeServiceimpl.listRoles();
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        model.addAttribute("listRoles", listRoles);
        return "update-employee";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable("id") UUID id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        employeeService.deleteEmployee(id);
        model.addAttribute("employees", employeeRepository.findAll());
        return "employee-list";
    }

    @RequestMapping("search")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Employee> listEmployees = employeeServiceimpl.findBySurname(keyword);
        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("keyword", keyword);

        return "employee-search";
    }

}