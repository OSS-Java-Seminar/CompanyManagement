package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(nullable = false)
    int price;

    @Column(name = "item_name", length = 50, nullable = false)
    String itemName;

    @ManyToMany
    Set<Invoice> invoices;

}
