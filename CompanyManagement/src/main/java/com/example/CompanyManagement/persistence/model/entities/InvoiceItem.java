package com.example.CompanyManagement.persistence.model.entities;

import javax.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

public class InvoiceItem {
    int InvoiceId;
    int ItemId;
    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
