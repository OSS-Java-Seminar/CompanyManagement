package com.example.CompanyManagement.persistence.model.entities;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    String name;
    String surname;
    long oib;
    String address;
    int workplaceId;

    @ManyToOne
    @JoinColumn(name = "workplace_id", referencedColumnName = "Id")
    private Workplace workplace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getOib() {
        return oib;
    }

    public void setOib(long oib) {
        this.oib = oib;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
