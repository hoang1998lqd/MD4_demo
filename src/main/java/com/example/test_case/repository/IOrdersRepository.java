package com.example.test_case.repository;


import com.example.test_case.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersRepository extends JpaRepository< Orders,Long> {
    //Trello #18
    @Query(value = "select * from orders where id like: id", nativeQuery = true)
    Page<Orders> findOrdersById (Long id, Pageable pageable);
}
