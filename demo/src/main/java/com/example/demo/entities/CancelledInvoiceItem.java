package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import javax.annotation.processing.Generated;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import java.util.Set;

@Table(name="CancelledInvoiceItems")
public class CancelledInvoiceItem {
    int CancelledInvoiceId;
    int ItemId;
    int Quantity;
    float Price;

}

