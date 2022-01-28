package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void updateCustomer(Customer newCustomer, UUID id) {
        var c = customerRepository.findById(id).orElse(null);

        c.setCustomerName(newCustomer.getCustomerName());
        c.setSurname(newCustomer.getSurname());
        c.setOib(newCustomer.getOib());
        c.setAddress(newCustomer.getAddress());
        c.setTelephone(newCustomer.getTelephone());
        c.setCity(newCustomer.getCity());

        customerRepository.save(c);
    }


    public ArrayList<Customer> findBySurname(String keyword) {
        var customers = customerRepository.findAll();
        var customerList = new ArrayList<Customer>();

        customers.forEach(c -> {
            if(keyword.equalsIgnoreCase(c.getSurname())) {
                customerList.add(c);
            }
        });
        return customerList;
    }

    public Page<Customer> getCustomerPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

}
