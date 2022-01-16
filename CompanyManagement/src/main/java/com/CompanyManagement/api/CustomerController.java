package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{oib}")
    public Customer findCustomerByOib(@PathVariable long oib) {
        return customerService.findCustomerByOib(oib);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable UUID id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) {
        customerService.updateCustomer(customer, id);
    }
}
