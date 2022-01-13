package com.CompanyManagement.service;

import com.CompanyManagement.persistence.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Component
@Service
public class InvoiceService {

        private final InvoiceRepository invoiceRepository;
}
