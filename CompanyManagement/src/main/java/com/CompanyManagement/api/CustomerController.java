package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.repositories.CustomerRepository;
import com.CompanyManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/customers/")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("signup")
    public String showSignUpForm(Customer customer) {
        return "customer-add";
    }

    @PostMapping("addCustomer")
    public String addCustomer(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer-add";
        }
        customerRepository.save(customer);
        return "redirect:page";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") UUID id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("customer", customer);
        return " ";
    }

    @PostMapping("update/{id}")
    public String updateCustomer(@PathVariable("id") UUID id, @Valid Customer customer, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "redirect:page";
        }
        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:/customers/page";
    }

    @GetMapping("delete/{id}")
    public String deleteCustomer(@PathVariable("id") UUID id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerService.deleteCustomerById(id);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:/customers/page";
    }

    @RequestMapping("search")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Customer> listCustomers = customerService.findBySurname(keyword);
        model.addAttribute("listCustomers", listCustomers);
        model.addAttribute("keyword", keyword);

        return "customer-search";
    }

    @GetMapping("listOfCustomers")
    public List<Customer> getCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());

        return customerService.getCustomers();
    }

    @GetMapping("page")
    public String getCustomers(@PageableDefault(size = 2) Pageable pageable,
                               Model model) {
        Page<Customer> page = customerService.getCustomerPage(pageable);
        model.addAttribute("page", page);
        List<Customer> listCustomer = page.getContent();
        model.addAttribute("listCustomer", listCustomer);
        return "customer-list";
    }


}
