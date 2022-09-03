package com.example.test_case.repository;

import com.example.test_case.model.Order_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrder_detail_Repository extends JpaRepository<Long, Order_detail> {
    //Trello #19
    @Query(value = "select * from order_detail where id like: id", nativeQuery = true)
    List<Order_detail> findOrder_detailById(Long id);
}
