package com.CompanyManagement.persistence.repositories;

import com.CompanyManagement.persistence.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
