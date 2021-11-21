package com.example.CompanyManagement.persistence.entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

@Getter
@Setter

public class InvoiceItem {
    int InvoiceId;
    int ItemId;
    int quantity;
}
