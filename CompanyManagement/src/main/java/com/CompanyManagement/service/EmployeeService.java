package com.CompanyManagement.service;


import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.entities.UserRole;
import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import com.CompanyManagement.web.EmployeeRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface EmployeeService extends UserDetailsService {


    public Collection<UserRole> listRoles();
    public Employee get(UUID id);
    Employee save(EmployeeRegistrationDto registrationDto);
    public String deleteEmployee(UUID id);



}

