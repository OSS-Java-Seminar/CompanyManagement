package com.CompanyManagement.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeRoleDto {

    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String roleName;
}
