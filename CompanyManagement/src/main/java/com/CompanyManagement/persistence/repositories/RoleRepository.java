package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
