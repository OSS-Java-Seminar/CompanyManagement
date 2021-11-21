package com.example.CompanyManagement.persistence.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String name;
    String surname;
    long oib;
    String address;
    int roleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id")
    private Role role;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Invoice> invoices;
}
