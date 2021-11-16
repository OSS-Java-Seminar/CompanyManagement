package com.example.CompanyManagement.persistence.model.entities;


import javax.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

@Entity
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int InvoiceId;
    String payingMethod;

    public String getPayingMethod() {
        return payingMethod;
    }

    public void setPayingMethod(String payingMethod) {
        this.payingMethod = payingMethod;
    }
}