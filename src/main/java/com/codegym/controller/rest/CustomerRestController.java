package com.codegym.controller.rest;


import com.codegym.model.Customer;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/customers")

public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> doCreate(@RequestBody Customer customer){

      customer.setId(0L);
      customer.getLocationRegion().setId(0L);

      customer.setBalance(new BigDecimal(0L));

      Customer newCustomer =  customerService.save(customer);

      return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
}
