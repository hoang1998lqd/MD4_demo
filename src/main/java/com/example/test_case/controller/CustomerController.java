package com.example.test_case.controller;

import com.example.test_case.model.Customer;
import com.example.test_case.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    public ICustomerService customerService;

    //Trello #11
    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    //Trello #10
    @GetMapping("/search/{search}")
    public ResponseEntity<?> findCustomerByPhoneNumber(@PathVariable("search") String phoneNumber) {
        List<Customer> customers = customerService.findByPhoneNumber(phoneNumber);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
