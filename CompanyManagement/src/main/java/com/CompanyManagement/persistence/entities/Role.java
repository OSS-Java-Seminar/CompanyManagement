package com.CompanyManagement.persistence.entities;

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
    int id;

    @Column(name = "role_name", length = 20, nullable = false, unique = true)
    String roleName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private List<Employee> employees;
}