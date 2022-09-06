package com.example.test_case.service.impl;

import com.example.test_case.model.Customer;
import com.example.test_case.model.CustomerPrinciple;
import com.example.test_case.repository.ICustomerRepository;
import com.example.test_case.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Customer> customerOptional = customerRepository.findByName(username);
       if (!customerOptional.isPresent()){
           throw new UsernameNotFoundException(username);
       }
        return CustomerPrinciple.build(customerOptional.get());
    }

    @Override
    public List<Customer> findAllByName(String name) {
        return customerRepository.findAllByNameContaining(name);
    }
}
