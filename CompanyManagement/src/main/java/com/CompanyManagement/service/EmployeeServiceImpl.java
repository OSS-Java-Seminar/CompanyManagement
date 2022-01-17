package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.entities.UserRole;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import com.CompanyManagement.persistence.repositories.UserRoleRepository;
import com.CompanyManagement.web.EmployeeRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(EmployeeRegistrationDto registrationDto) {
        Employee employee = new Employee(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getOib(), registrationDto.getAddress(), registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPasswd()), Arrays.asList(new UserRole("ROLE_USER")));
        return employeeRepository.save(employee);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(s);
        if(employee == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPasswd(),mapRolesToAuthorities(employee.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    public void assignRoleToEmployee(UUID employeeId, UUID roleId) {
        var e = employeeRepository.findById(employeeId).orElse(null);
        var role = userRoleRepository.findById(roleId).orElse(null);

        e.setRoles((Collection<UserRole>) role);
        employeeRepository.save(e);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findByOib(long oib) {
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
