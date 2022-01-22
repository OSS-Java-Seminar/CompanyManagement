package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.entities.UserRole;
import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import com.CompanyManagement.service.EmployeeService;
import com.CompanyManagement.service.EmployeeServiceImpl;
import com.CompanyManagement.web.EmployeeRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

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
        return "home";
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
        Employee employee1 = new Employee(employee.getEmployeeName(), employee.getSurname(), employee.getOib(), employee.getAddress(), employee.getEmail(), passwordEncoder.encode(employee.getPasswd()), Arrays.asList(new UserRole("EMPLOYEE")));
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
        return "home";
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
        return "home";
    }

}