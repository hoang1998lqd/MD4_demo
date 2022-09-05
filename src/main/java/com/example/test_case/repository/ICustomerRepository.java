package com.example.test_case.repository;

import com.example.test_case.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByNameContaining(String name);

    Optional<Customer> findByName(String name);

}
