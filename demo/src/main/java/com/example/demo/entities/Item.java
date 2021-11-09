package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import java.util.Set;
@Entity
@Table(name="Items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int Price;
    String Name;
}
