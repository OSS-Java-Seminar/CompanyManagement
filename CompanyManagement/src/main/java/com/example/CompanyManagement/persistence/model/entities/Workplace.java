package com.example.CompanyManagement.persistence.model.entities;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import javax.persistence.*;

@Entity
public class Workplace {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
