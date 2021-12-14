package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InvoiceRepository extends CrudRepository<Invoice, UUID> {
}
