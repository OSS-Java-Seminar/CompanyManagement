package com.CompanyManagement.api;

import com.CompanyManagement.service.EmployeeService;
import com.CompanyManagement.web.EmployeeRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class EmployeeRegistrationController {

    private EmployeeService employeeService;

    public EmployeeRegistrationController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ModelAttribute("employee")
    public EmployeeRegistrationDto registrationDto(){
            return new EmployeeRegistrationDto();
    }


    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerEmployeeAccount(@ModelAttribute("employee")EmployeeRegistrationDto registrationDto){
        employeeService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
