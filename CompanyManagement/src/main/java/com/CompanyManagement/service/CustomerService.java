package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer findCustomerByOib(long oib) {
        return customerRepository.findByOib(oib);
    }

    public void deleteCustomerById(UUID id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer newcustomer, UUID id) {
        var c = customerRepository.findById(id).orElse(null);

        c.setCustomerName(newcustomer.getCustomerName());
        c.setSurname(newcustomer.getSurname());
        c.setOib(newcustomer.getOib());
        c.setAddress(newcustomer.getAddress());
        c.setTelephone(newcustomer.getTelephone());
        c.setCity(newcustomer.getCity());

        customerRepository.save(c);
    }
}
