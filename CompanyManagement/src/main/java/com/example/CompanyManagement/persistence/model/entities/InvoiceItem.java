package com.example.CompanyManagement.persistence.model.entities;

import javax.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

public class InvoiceItem {
    int InvoiceId;
    int ItemId;
    int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "Id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "Id")
    private Invoice invoice;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
