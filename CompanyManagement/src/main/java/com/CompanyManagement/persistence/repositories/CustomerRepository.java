package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

   void deleteByOib(long oib);
   Customer findByOib(long oib);

}
