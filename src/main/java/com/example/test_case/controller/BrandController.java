package com.example.test_case.controller;

import com.example.test_case.model.Brand;
import com.example.test_case.model.Product;
import com.example.test_case.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/brands")
public class BrandController {
    @Autowired
    private IBrandService iBrandService;
    @GetMapping
    private ResponseEntity<List<Brand>> findAll() {
        return new ResponseEntity<>(iBrandService.findAll(), HttpStatus.OK);
    }
}
