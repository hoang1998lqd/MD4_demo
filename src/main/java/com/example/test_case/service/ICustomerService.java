package com.example.test_case.service;

import com.example.test_case.model.Customer;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> findByPhoneNumber(String phoneNumber);
}
