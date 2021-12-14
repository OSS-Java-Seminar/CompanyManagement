package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 35, nullable = false)
    String employeeName;

    @Column(length = 35, nullable = false)
    String surname;

    @Column(length = 11, nullable = false, unique = true)
    long oib;

    @Column(length = 50)
    String address;

    @Column(name = "role_id", nullable = false, unique = true)
    private UUID roleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserRole role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Invoice> invoices;
}
