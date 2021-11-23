package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "invoice_number", nullable = false, unique = true)
    int invoiceNumber;
    @Column(name = "total_amount", nullable = false, unique = false)
    float totalAmount;
    @Column(name = "date_of_issue", length = 23, nullable = false, unique = false)
    String dateOfIssue;
    @Column(name = "due_date", length = 23, nullable = false, unique = true)
    String dueDate;
    @Column(name = "vat", nullable = false, unique = true)
    float vat;
    @Column(name = "discount", nullable = true, unique = false)
    float discount;
    @Column(name = "payment_status", length = 10, nullable = false, unique = false)
    String paymentStatus;
    @Column(name = "payment_method", length = 15, nullable = false, unique = false)
    String paymentMethod;
    @Column(name = "customer_id", nullable = false, unique = false)
    int customerId;
    @Column(name = "employee_id", nullable = false, unique = false)
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

