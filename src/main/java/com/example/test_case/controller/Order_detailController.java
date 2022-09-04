package com.example.test_case.controller;

import com.example.test_case.model.Order_detail;
import com.example.test_case.service.IOrder_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/order-detail")
public class Order_detailController {
    @Autowired
    public IOrder_detailService order_detailService;

    @GetMapping("/order-detail")
    public ResponseEntity<List<Order_detail>> findAllOrder_details() {
        return new ResponseEntity<>(order_detailService.findAll(), HttpStatus.OK);
    }

    //Trello #19
    @GetMapping("/order-detail/{id}")
    public ResponseEntity<Order_detail> detail(@PathVariable("id") Long id) {
        Optional<Order_detail> order_detailOptional = order_detailService.findById(id);
        if (order_detailOptional.isPresent()) {
            return new ResponseEntity<>(order_detailOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
