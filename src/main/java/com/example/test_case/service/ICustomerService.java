package com.example.test_case.service;

import com.example.test_case.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends UserDetailsService, IGeneralService<Customer> {
    List<Customer> findAllByName(String name);

}
