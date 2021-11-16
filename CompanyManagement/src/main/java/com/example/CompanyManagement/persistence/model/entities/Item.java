package com.example.CompanyManagement.persistence.model.entities;

import javax.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int price;
    String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
