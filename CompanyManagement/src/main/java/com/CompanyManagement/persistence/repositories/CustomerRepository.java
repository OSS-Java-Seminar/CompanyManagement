package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    /*Customer save(Customer newCustomer);
    List<Customer> readAllCustomers();
    Customer readByName(String customerName);
    boolean update(long id);
    boolean delete(long id);*/

}
