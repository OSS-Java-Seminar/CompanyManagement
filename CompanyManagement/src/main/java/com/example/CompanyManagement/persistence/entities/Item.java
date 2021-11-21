package com.example.CompanyManagement.persistence.entities;

import lombok.Setter;
import lombok.Getter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int price;
    String name;
}
