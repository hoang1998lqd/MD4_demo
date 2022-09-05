package com.example.test_case.service;

import com.example.test_case.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> findByName(String name);
    List<Product> findProductByFilter(Long id);

    List<Product> findAllByBrand_Id(Long id);
    List<Product> findAllByCategory_Id(Long id);
    List<Product> findAllByColor(String color);
    List<Product> findAllByPrice(double price);
}
