package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long>
{


    Customer save(Customer newCustomer);
}




