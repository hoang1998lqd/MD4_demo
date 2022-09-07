package com.example.test_case.repository;

import com.example.test_case.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);

    Optional<Customer> findByEmailAddressAndPassword(String email, String password);

    Optional<Customer> findByEmailAddress(String email);

}
