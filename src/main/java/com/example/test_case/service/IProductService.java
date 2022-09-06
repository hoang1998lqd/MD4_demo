package com.example.test_case.service;

import com.example.test_case.model.DTO.DTOProduct;
import com.example.test_case.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
import com.example.test_case.model.DTO.DTOProduct;
import com.example.test_case.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService  {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
    Long findIdNewProduct();
    List<DTOProduct> getAllDTO();
}
