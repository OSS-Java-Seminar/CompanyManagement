package com.CompanyManagement.service;

import com.CompanyManagement.persistence.entities.Customer;
import com.CompanyManagement.persistence.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer findCustomerByOib(long oib) {
        return customerRepository.findByOib(oib);
    }

    public void deleteCustomerById(UUID id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer newCustomer, UUID id) {
        var c = customerRepository.findById(id).orElse(null);

        c.setCustomerName(newCustomer.getCustomerName());
        c.setSurname(newCustomer.getSurname());
        c.setOib(newCustomer.getOib());
        c.setAddress(newCustomer.getAddress());
        c.setTelephone(newCustomer.getTelephone());
        c.setCity(newCustomer.getCity());

        customerRepository.save(c);
    }


    public List<Customer> findBySurnameIgnoreCase(@Pattern(regexp = "[A-Za-z]") String keyword) {
        var customers = customerRepository.findAll();
        var customerList = new ArrayList<Customer>();

        customers.forEach(c -> {
            if(c.getSurname().toLowerCase().contains(keyword)) {
                customerList.add(c);
            }
        });
        return customerList;
    }

    /*public Page<Customer> getCustomerPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public List<Customer> findAllByOrderBySurnameAsc() {
        return customerRepository.findAllByOrderBySurnameAsc(Sort.by(Sort.Direction.ASC, "surname"));
    }*/

    //NOVI PAGING&SORTING
    public Page<Customer> listAll(int pageNumber, String sortField, String sortDir) {
        Sort sort = Sort.by("surname");
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 2, sort);
        return customerRepository.findAll(pageable);
    }

}
