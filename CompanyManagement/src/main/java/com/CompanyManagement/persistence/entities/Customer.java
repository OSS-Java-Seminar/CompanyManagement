package com.CompanyManagement.persistence.entities;

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
    int id;

    @Column(name = "customer_name", length = 35, nullable = false)
    String customerName;

    @Column(length = 35, nullable = false)
    String surname;

    @Column(length = 11, nullable = false, unique = true)
    String oib;

    @Column(length = 50)
    String address;

    @Column(length = 35)
    String telephone;

    @Column(length = 50)
    String city;

    @Column(name = "payment_id", nullable = false, unique = true)
    int paymentId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Invoice> invoices;

}