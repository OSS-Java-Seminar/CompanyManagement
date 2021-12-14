package com.CompanyManagement.api;

import com.CompanyManagement.service.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class UserRoleController {

    private final UserRoleService roleService;

}
