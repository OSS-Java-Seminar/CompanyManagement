package com.CompanyManagement.service;

import com.CompanyManagement.dto.EmployeeRoleDto;
import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public List<EmployeeRoleDto> getAllEmployeesRole(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private EmployeeRoleDto convertEntityToDto(Employee employee){
        EmployeeRoleDto employeeRoleDto = new EmployeeRoleDto();
        employeeRoleDto.setEmployeeId(employee.getId());
        employeeRoleDto.setFirstName(employee.getEmployeeName());
        employeeRoleDto.setLastName(employee.getSurname());
        employeeRoleDto.setRoleName(employee.getUserRole().getRoleName());
        return employeeRoleDto;
    }


}

