package com.example.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter


public class InvoiceItem {
    @Column(name = "invoice_id", nullable = false, unique = true)
    int InvoiceId;
    @Column(name = "item_id", nullable = false, unique = true)
    int ItemId;
    @Column(name = "quantity",  nullable = false, unique = false)
    int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id")
    private Item item;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id")
    private Invoice invoice;
}
