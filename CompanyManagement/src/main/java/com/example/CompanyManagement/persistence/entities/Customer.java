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
    String name;
    String surname;
    String oib;
    String address;
    String telephone;
    String city;
    int paymentId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Invoice> invoices;
}