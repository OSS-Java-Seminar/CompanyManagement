package com.example.demo.entities;
import javax.persistence.*;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import java.util.Set;
@Entity
@Table(name="Invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String InvoiceNumber;
    float TotalAmount;
    String DateOfIssue;
    String DueDate;
    int Vat;
    float Discount;
    String PaymentMethod;
    int CustomerId;
    int EmployeeId;
}

