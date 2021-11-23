package com.example.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(length = 35, nullable = false, unique = false)
    String name;
    @Column(length = 35, nullable = false, unique = false)
    String surname;
    @Column(length = 11, nullable = false, unique = true)
    String oib;
    @Column(length = 50, nullable = true, unique = false)
    String address;
    @Column(length = 35, nullable = true, unique = false)
    String telephone;
    @Column(length = 50, nullable = true, unique = false)
    String city;
    @Column(name = "payment_id", nullable = false, unique = true)
    int paymentId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Invoice> invoices;
}