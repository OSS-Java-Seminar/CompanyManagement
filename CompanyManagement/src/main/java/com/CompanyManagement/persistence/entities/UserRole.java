package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 20, nullable = false, unique = true)
    String roleName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private List<Employee> employees;
}