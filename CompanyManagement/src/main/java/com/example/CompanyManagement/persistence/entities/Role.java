package com.example.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "role_name", length = 20, nullable = false, unique = true)
    String roleName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Employee> employees;
}