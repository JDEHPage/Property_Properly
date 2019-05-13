package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Customer;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping( value = "/" )
    public List<Customer> getAllCustomers(){ return customerRepository.findAll(); }

    @GetMapping( value = "{id}" )
    public Optional<Customer> getSingleCustomer(@PathVariable Long id){ return customerRepository.findById(id); }

}
