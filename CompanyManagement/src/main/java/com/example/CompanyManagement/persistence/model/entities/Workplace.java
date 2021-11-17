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

    @OneToMany
    @JoinColumn(name = "employee_id", referencedColumnName = "Id")
    private Workplace workplace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
