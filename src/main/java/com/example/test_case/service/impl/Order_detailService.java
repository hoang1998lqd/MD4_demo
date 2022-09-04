package com.example.test_case.service.impl;

import com.example.test_case.model.Order_detail;
import com.example.test_case.repository.IOrder_detailRepository;
import com.example.test_case.service.IOrder_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Order_detailService implements IOrder_detailService {
    @Autowired
    public IOrder_detailRepository order_detailRepository;
    @Override
    public List<Order_detail> findAll() {
        return order_detailRepository.findAll();
    }

    @Override
    public Optional<Order_detail> findById(Long id) {
        return order_detailRepository.findById(id);
    }

    @Override
    public Order_detail save(Order_detail order_detail) {
        return order_detailRepository.save(order_detail);
    }

    @Override
    public void delete(Long id) {
        order_detailRepository.deleteById(id);
    }
}
