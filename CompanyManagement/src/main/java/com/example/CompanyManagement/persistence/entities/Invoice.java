package com.example.CompanyManagement.persistence.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int invoiceNumber;
    float totalAmount;
    String dateOfIssue;
    String dueDate;
    int vat;
    float discount;
    String paymentStatus;
    String paymentMethod;
    int customerId;
    int employeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id")
    private Employee employee;
    @OneToMany(fetch = FetchType.EAGER)
    private List<InvoiceItem> invoiceitems;

}

