package com.example.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter

public class InvoiceItem {
    int InvoiceId;
    int ItemId;
    int quantity;
}
