package com.CompanyManagement.service;

import com.CompanyManagement.persistence.repositories.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Component
@Service
public class UserRoleService {

    private final UserRoleRepository UserRoleRepository;
}
