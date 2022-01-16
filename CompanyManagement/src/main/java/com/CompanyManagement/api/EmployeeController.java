package com.CompanyManagement.api;

import com.CompanyManagement.dto.EmployeeRoleDto;
import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees-role")
    public List<EmployeeRoleDto> getAllEmployeesRole(){
        return employeeService.getAllEmployeesRole();
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
       employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{oib}")
    public Employee findEmployeeByOib(@PathVariable long oib) {
        return employeeService.findEmployeeByOib(oib);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable UUID id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable UUID id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee, id);
    }

}