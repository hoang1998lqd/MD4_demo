package com.example.test_case.repository;

import com.example.test_case.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IOrdersRepository extends JpaRepository<Long, Orders> {
    //Trello #18
    @Query(value = "select * from orders where id like: id", nativeQuery = true)
    List<Orders> findAllOrdersById (Long id);

    @Query(value = "select * from orders where date_order =: dor", nativeQuery = true)
    List<Orders> findAllOrdersByDateContaining(@Param("dor")LocalDateTime dor);

}
