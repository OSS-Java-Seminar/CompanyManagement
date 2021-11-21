package com.example.CompanyManagement.persistence.entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

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