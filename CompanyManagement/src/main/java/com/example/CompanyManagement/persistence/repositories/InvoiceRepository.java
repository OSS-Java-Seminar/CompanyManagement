package com.example.CompanyManagement.persistence.repositories;

import com.example.CompanyManagement.persistence.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {
}
