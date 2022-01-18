package com.CompanyManagement.service;


import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.web.EmployeeRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface EmployeeService extends UserDetailsService {

    Employee save(EmployeeRegistrationDto registrationDto);

}

