package com.example.CompanyManagement.persistence.repositories;

import com.example.CompanyManagement.persistence.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
