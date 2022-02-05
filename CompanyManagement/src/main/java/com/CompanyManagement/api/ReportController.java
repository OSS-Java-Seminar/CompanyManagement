package com.CompanyManagement.api;

import com.CompanyManagement.reports.InvoiceReport;
import com.CompanyManagement.reports.MonthlyReport;
import com.CompanyManagement.reports.PaymentMethodCardReport;
import com.CompanyManagement.reports.PaymentMethodCashReport;
import com.CompanyManagement.service.InvoiceService;
import com.CompanyManagement.util.MapperUtils;
import com.CompanyManagement.web.dto.InvoiceDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Controller
@RequestMapping("/reports")
@SessionAttributes("invoice")
public class ReportController {

    private final InvoiceService invoiceService;

    public ReportController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice")
    public String createInvoiceReportForm(Model model) {
        model.addAttribute("invoices", MapperUtils.mapList(invoiceService.getInvoices(), InvoiceDto.class));
        model.addAttribute("standardDate", new Date());
        return "report-invoice";
    }

    @GetMapping("/invoices/pdf")
    public void downloadPdfFile(HttpServletResponse response) {
        InvoiceDto invoice = MapperUtils.mapObject(invoiceService.getInvoices(), InvoiceDto.class);
        response.setContentType("application/pdf");
        String headerValue = "attachment; filename=invoices_total_report" + ".pdf";
        response.setHeader("Content-Disposition", headerValue);
        InvoiceReport exporter = new InvoiceReport(invoiceService);
        exporter.export(response);
    }

    @GetMapping("/monthly/pdf")
    public void downloadPdfFileMonthly(HttpServletResponse response) {
        InvoiceDto invoice = MapperUtils.mapObject(invoiceService.getInvoices(), InvoiceDto.class);
        response.setContentType("application/pdf");
        String headerValue = "attachment; filename=invoices_total_report" + ".pdf";
        response.setHeader("Content-Disposition", headerValue);
        MonthlyReport exporter = new MonthlyReport(invoiceService);
        exporter.export(response);
    }

    @GetMapping("/paymentMethodCash/pdf")
    public void downloadPdfFileCash(HttpServletResponse response) {
        InvoiceDto invoice = MapperUtils.mapObject(invoiceService.getInvoices(), InvoiceDto.class);
        response.setContentType("application/pdf");
        String headerValue = "attachment; filename=invoices_total_report" + ".pdf";
        response.setHeader("Content-Disposition", headerValue);
        PaymentMethodCashReport exporter = new PaymentMethodCashReport(invoiceService);
        exporter.export(response);
    }

    @GetMapping("/paymentMethodCard/pdf")
    public void downloadPdfFileCard(HttpServletResponse response) {
        InvoiceDto invoice = MapperUtils.mapObject(invoiceService.getInvoices(), InvoiceDto.class);
        response.setContentType("application/pdf");
        String headerValue = "attachment; filename=invoices_total_report" + ".pdf";
        response.setHeader("Content-Disposition", headerValue);
        PaymentMethodCardReport exporter = new PaymentMethodCardReport(invoiceService);
        exporter.export(response);
    }

}
