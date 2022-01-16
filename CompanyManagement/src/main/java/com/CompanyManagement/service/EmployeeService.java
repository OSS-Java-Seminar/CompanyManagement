package com.CompanyManagement.service;

import com.CompanyManagement.dto.EmployeeRoleDto;
import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findEmployeeByOib(long oib) {
        return employeeRepository.findByOib(oib);
    }

    public void deleteEmployeeById(UUID id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee newEmployee, UUID id) {
        var e = employeeRepository.findById(id).orElse(null);

        e.setEmployeeName(newEmployee.getEmployeeName());
        e.setSurname(newEmployee.getSurname());
        e.setOib(newEmployee.getOib());
        e.setAddress(newEmployee.getAddress());
        e.setEmail(newEmployee.getEmail());
        e.setPasswd(newEmployee.getPasswd());

        employeeRepository.save(e);
    }
}

