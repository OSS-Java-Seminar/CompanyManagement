package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.UserRole;
import com.CompanyManagement.persistence.repositories.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRole createUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }

    public List<UserRole> getUserRoles() {
        return (List<UserRole>) userRoleRepository.findAll();
    }

    public void deleteUserRoleById(UUID id) {
        userRoleRepository.deleteById(id);
    }

    public void updateUserRole(UserRole newUserRole, UUID id) {
        var role = userRoleRepository.findById(id).orElse(null);

        role.setRoleName(newUserRole.getRoleName());

        userRoleRepository.save(role);
    }
}