package com.CompanyManagement.api;

import com.CompanyManagement.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //GET
    @GetMapping(value = "/message")
    public String getMessage(){
        return "Hi controller";
    }
}