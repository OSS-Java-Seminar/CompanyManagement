package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(nullable = false, unique = true)
    int invoiceNumber;

    @Column(nullable = false)
    float totalAmount;

    @Column(length = 23, nullable = false)
    String dateOfIssue;

    @Column(length = 23, nullable = false)
    String dueDate;

    @Column(nullable = false)
    float vat;

    @Column()
    float discount;

    @Column(length = 10, nullable = false)
    String paymentStatus;

    @Column(length = 15, nullable = false)
    String paymentMethod;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "employee_id", nullable = false)
    private UUID employeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToMany
    Set<Item> items;

}

