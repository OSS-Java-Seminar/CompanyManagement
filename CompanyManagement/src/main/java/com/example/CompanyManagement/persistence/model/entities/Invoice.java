package com.example.CompanyManagement.persistence.model.entities;
import javax.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int invoiceNumber;
    float totalAmount;
    String dateOfIssue;
    String dueDate;
    int vat;
    float discount;
    String paymentStatus;
    int customerId;
    int employeeId;

    @OneToOne
    @JoinColumn(name = "payment_details_id", referencedColumnName = "Id")
    private PaymentDetails paymentDetails;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "Id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "Id")
    private Employee employee;

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

