package com.CompanyManagement;

import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.entities.UserRole;
import com.CompanyManagement.persistence.repositories.EmployeeRepository;
import com.CompanyManagement.persistence.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CompanyManagementApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;


	@Override
	public void run(String... args) throws Exception {

		UserRole userRole1 = new UserRole();
		userRole1.setRoleName("ADMIN");
		userRoleRepository.save(userRole1);
		UserRole userRole2 = new UserRole();
		userRole2.setRoleName("USER");
		userRoleRepository.save(userRole2);

		Employee employee1 = new Employee();
		employee1.setEmployeeName("Marin");
		employee1.setSurname("Visković");
		employee1.setAddress("MalaUlica 59");
		employee1.setOib(98309825);
		employee1.setUserRole(userRole1);
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeName("Vesna");
		employee2.setSurname("Simundic-Bendic");
		employee2.setAddress("MalaUlicaw 59");
		employee2.setOib(98309821);
		employee2.setUserRole(userRole2);
		employeeRepository.save(employee2);

		Employee employee3 = new Employee();
		employee3.setEmployeeName("Josipa");
		employee3.setSurname("...");
		employee3.setAddress("MalaUlicav 59");
		employee3.setOib(98309824);
		employee3.setUserRole(userRole2);
		employeeRepository.save(employee3);



	}



}
