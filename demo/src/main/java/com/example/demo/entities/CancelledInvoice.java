package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import java.util.Set;
import java.time.LocalDate;
import static java.lang.System.*;

@Entity
@Table(name="CancelledInvoices")
public class CancelledInvoice {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    String CancelledInvoiceNumber;
    float Amount;
    String DateOfIssue;
    String DueDate;
    int Vat;
    float Discount;
    int InvoiceId;
    int ItemId;

}

