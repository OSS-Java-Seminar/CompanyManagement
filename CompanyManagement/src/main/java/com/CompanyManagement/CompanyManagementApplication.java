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

	@Override
	public void run(String... args) throws Exception {
	}

}

