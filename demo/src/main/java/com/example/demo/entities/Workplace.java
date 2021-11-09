package com.example.demo.entities;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="Workplaces")

public class Workplace {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    String Name;

}
