package com.CompanyManagement.api;

import com.CompanyManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping(value = "/message")
    public String getMessage(){
        return "Hi controller";
    }
}