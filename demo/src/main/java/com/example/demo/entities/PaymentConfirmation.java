package com.example.demo.entities;


import javax.persistence.*;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import java.util.Set;
@Entity
@Table(name="PaymentConfirmations")
public class PaymentConfirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String PaymentConfirmationNumber;
    int InvoiceId;
}