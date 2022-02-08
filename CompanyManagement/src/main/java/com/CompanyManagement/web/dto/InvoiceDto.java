package com.CompanyManagement.web.dto;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.entities.Employee;
import com.CompanyManagement.persistence.entities.Invoice;
import com.CompanyManagement.persistence.entities.ItemInvoice;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class InvoiceDto {

    private UUID id;
    private int invoiceNumber;
    private float totalAmount;
    private String dateOfIssue;
    private String dueDate;
    private float vat;

    @Max(value = 40)
    private float discount;

    private String paymentStatus;
    private String paymentMethod;

    @NotNull(message = "Customer must be selected.")
    private UUID customerId;
    private Customer customer;

    private Employee employee;

    private UUID itemId;
    private List<ItemInvoice> items;

    public void addItemInvoice(ItemInvoice item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public void calculateTotal() {
        float total = 0.0f;
        for (ItemInvoice item : items) {
            total += item.calculateImport();
        }

        this.totalAmount = total;
    }

}
