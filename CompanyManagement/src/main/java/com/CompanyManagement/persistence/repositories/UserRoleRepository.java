package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRoleRepository extends CrudRepository<UserRole, UUID> {
}
