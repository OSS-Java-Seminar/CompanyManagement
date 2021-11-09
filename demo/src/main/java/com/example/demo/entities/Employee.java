package com.example.demo.entities;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    String Name;
    String Surname;
    long Oib;
    String Address;
    int WorkplaceId;

}
