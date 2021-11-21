package com.example.CompanyManagement.persistence.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Invoice {
    @ManyToOne(optional = false)
    @JoinColumn(name = "p_details_invoice_id", nullable = false)
    @Id
    private PaymentDetails pDetails;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pDetails_FK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int invoiceNumber;
    float totalAmount;
    String dateOfIssue;
    String dueDate;
    int vat;
    float discount;
    String paymentStatus;
    int customerId;
    int employeeId;
}

