package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
