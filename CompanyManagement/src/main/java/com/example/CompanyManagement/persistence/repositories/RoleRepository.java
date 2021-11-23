package com.example.CompanyManagement.persistence.repositories;

import com.example.CompanyManagement.persistence.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {
}
