package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee findByEmail(String email);
    Employee findByOib(long oib);

}