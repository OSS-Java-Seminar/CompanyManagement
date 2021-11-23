package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false, unique = false)
    int price;
    @Column(length = 50, nullable = false, unique = false)
    String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<InvoiceItem> invoiceitems;
}
