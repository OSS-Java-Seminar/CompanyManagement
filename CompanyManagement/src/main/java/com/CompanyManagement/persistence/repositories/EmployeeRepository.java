package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {

}
