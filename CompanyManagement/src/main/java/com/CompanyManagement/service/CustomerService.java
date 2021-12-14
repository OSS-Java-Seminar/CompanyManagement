package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Component
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void TestCreate(Customer c) {
        customerRepository.save(c);
    }

}
