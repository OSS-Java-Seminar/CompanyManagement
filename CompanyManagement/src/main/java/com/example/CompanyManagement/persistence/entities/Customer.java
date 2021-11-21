package com.example.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

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
    //int postalCode;
    String city;
    int paymentId;
}