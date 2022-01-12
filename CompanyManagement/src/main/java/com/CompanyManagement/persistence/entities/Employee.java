package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(length = 35, nullable = false)
    String employeeName;

    @Column(length = 35, nullable = false)
    String surname;

    @Column(length = 11, nullable = false, unique = true)
    long oib;

    @Column(length = 50)
    String address;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id")
    private UserRole userRole;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Invoice> invoices;
}
