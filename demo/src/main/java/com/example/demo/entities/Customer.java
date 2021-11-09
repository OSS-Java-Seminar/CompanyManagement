package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import java.util.Set;
@Entity
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    String Name;
    String Surname;
    long Oib;
    String Address;
    long Telephone;
    int PostalCode;
    String City;
    int PaymentId;

}