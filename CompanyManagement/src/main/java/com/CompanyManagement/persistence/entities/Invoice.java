package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "invoice_number", nullable = false, unique = true)
    int invoiceNumber;

    @Column(name = "total_amount", nullable = false)
    float totalAmount;

    @Column(name = "date_of_issue", length = 23, nullable = false)
    String dateOfIssue;

    @Column(name = "due_date", length = 23, nullable = false)
    String dueDate;

    @Column(nullable = false)
    float vat;

    @Column()
    float discount;

    @Column(name = "payment_status", length = 10, nullable = false)
    String paymentStatus;

    @Column(name = "payment_method", length = 15, nullable = false)
    String paymentMethod;

    @Column(name = "customer_id", nullable = false)
    int customerId;

    @Column(name = "employee_id", nullable = false)
    int employeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToMany
    Set<Item> items;

}

