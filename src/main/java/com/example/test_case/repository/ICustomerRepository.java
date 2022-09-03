package com.example.test_case.repository;

import com.example.test_case.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Long, Customer> {

//Trello #11
@Query(value = "select * from customer where id like: id", nativeQuery = true)
    List<Customer> findAllByCustomer(Long id);

//Trello #10
@Query(value = "select * from customer where phone_number like: phone_number", nativeQuery = true)
    List<Customer> findCustomerByPhone(String phoneNumber);

}
