package com.CompanyManagement.service;

import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Component
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
}

