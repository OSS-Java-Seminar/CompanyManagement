package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.entities.UserRole;
import com.CompanyManagement.service.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class UserRoleController {

    private final UserRoleService roleService;

    @PostMapping
    public void createUserRole(@RequestBody UserRole userRole) {
        roleService.createUserRole(userRole);
    }

    @GetMapping
    public List<UserRole> getUserRoles() {
        return roleService.getUserRoles();
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable UUID id) {
        roleService.deleteUserRoleById(id);
    }

    @PutMapping("/{id}")
    public void updateUserRole(@PathVariable UUID id, @RequestBody UserRole userRole) {
        roleService.updateUserRole(userRole, id);
    }

}
