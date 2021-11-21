package com.example.CompanyManagement.persistence.entities;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
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