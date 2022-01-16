package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee findByOib(long oib);

}
