package com.CompanyManagement.api;

import com.CompanyManagement.dto.EmployeeRoleDto;
import com.CompanyManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees-role")
    public List<EmployeeRoleDto> getAllEmployeesRole(){
        return employeeService.getAllEmployeesRole();
    }
}