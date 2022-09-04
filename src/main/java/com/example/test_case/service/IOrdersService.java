package com.example.test_case.service;

import com.example.test_case.model.Orders;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrdersService extends IGeneralService<Orders> {
    List<Orders> findOrdersByDate(LocalDateTime date_order);
}
