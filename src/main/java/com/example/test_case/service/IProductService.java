package com.example.test_case.service;

import com.example.test_case.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> findByName(String name);
    List<Product> findByCategory(Long id);
    List<Product> findByBrand(Long id);
}
