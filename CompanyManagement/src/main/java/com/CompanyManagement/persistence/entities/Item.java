package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(length = 50, nullable = false)
    String itemName;

    @Column(nullable = false)
    float price;

    @Column()
    int quantity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "items_categories",
            joinColumns = @JoinColumn(
                    name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id", referencedColumnName = "id"))

    private Collection<Category> categories;

}
