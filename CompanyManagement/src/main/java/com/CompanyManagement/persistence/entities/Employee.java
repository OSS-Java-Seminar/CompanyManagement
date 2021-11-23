package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(length = 35, nullable = false, unique = false)
    String name;
    @Column(length = 35, nullable = false, unique = false)
    String surname;
    @Column(length = 11, nullable = false, unique = true)
    long oib;
    @Column(length = 50, nullable = true, unique = false)
    String address;
    @Column(name = "role_id", nullable = false, unique = true)
    int roleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id")
    private Role role;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Invoice> invoices;
}
