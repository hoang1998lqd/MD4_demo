package com.example.test_case.service.impl;


import com.example.test_case.model.Customer;
import com.example.test_case.repository.ICustomerRepository;
import com.example.test_case.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    public ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByPhoneNumber(String phoneNumber) {
        return customerRepository.findAllCustomerByPhone_numberContaining(phoneNumber);
    }
}
