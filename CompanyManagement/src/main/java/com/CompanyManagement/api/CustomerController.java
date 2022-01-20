package com.CompanyManagement.api;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.repositories.CustomerRepository;
import com.CompanyManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{oib}")
    public Customer findCustomerByOib(@PathVariable long oib) {
        return customerService.findCustomerByOib(oib);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable UUID id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) {
        customerService.updateCustomer(customer, id);
    }

    //VIEW
    @GetMapping("/listOfCustomers")
    public String getCustomers(Model model) {
        var customer = customerService.getCustomers();
        model.addAttribute("listCustomers", customer);
        return "customer-list";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Customer customer) {
        return "customer-add";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer-add";
        }
        customerRepository.save(customer);
        return "redirect:listOfCustomers";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") UUID id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") UUID id, @Valid Customer customer, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "update-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "customer-list";
    }

}
