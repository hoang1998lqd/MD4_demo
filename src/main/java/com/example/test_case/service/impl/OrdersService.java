package com.example.test_case.service.impl;

import com.example.test_case.model.Orders;
import com.example.test_case.repository.IOrdersRepository;
import com.example.test_case.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements IOrdersService {
    @Override
    public List<Orders> findOrdersByDate(LocalDateTime date_order) {
        return ordersRepository.findAllOrdersByDateContaining(date_order);
    }

    @Autowired
    public IOrdersRepository ordersRepository;
    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }


}
