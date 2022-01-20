package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
       employeeServiceImpl.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeServiceImpl.getEmployees();
    }

    @GetMapping("/{oib}")
    public Employee findEmployeeByOib(@PathVariable long oib) {
        return employeeServiceImpl.findByOib(oib);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable UUID id) {
        employeeServiceImpl.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable UUID id, @RequestBody Employee employee) {
        employeeServiceImpl.updateEmployee(employee, id);
    }

    @PostMapping("/assign/{userId}/{roleId}")
    public void assignRoleToUser(@PathVariable UUID userId, @PathVariable UUID roleId)
    {
        employeeServiceImpl.assignRoleToUser(userId, roleId);
    }



}