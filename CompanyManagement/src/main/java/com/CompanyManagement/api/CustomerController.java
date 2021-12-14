package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void TestCreate(@RequestBody Customer c) {
        customerService.TestCreate(c);
    }
}
