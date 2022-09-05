package com.example.test_case.repository;

import com.example.test_case.model.Order_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IOrder_detailRepository extends JpaRepository<Order_detail, Long> {

}
