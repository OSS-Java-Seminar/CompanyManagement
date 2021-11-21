package com.example.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String name;
}