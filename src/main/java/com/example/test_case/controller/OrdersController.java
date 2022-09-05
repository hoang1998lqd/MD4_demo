package com.example.test_case.controller;

import com.example.test_case.model.Orders;
import com.example.test_case.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/orders")
public class OrdersController {
    @Autowired
    public IOrdersService ordersService;

    //Trello #18
    @GetMapping
    public ResponseEntity<List<Orders>> findAllOrders() {
        return new ResponseEntity<>(ordersService.findAll(), HttpStatus.OK);
    }

    //Trello #20
    @GetMapping("/search/{search}")
    public ResponseEntity<?> findOrdersByDate(@PathVariable("search")LocalDateTime date_order) {
        List<Orders> ordersList = ordersService.findOrdersByDate(date_order);
        if (ordersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    //Trello #24
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrders(@PathVariable("id") Long id) {
        Optional<Orders> ordersOptional = ordersService.findById(id);
        if (ordersOptional.isPresent()) {
            ordersService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
