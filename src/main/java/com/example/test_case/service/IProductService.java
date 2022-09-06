package com.example.test_case.service;

import com.example.test_case.conmon.IGeneralService;
import com.example.test_case.model.DTO.DTOProduct;
import com.example.test_case.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
    Long findIdNewProduct();
    List<DTOProduct> getAllDTO();
    List<Product> findProductByPriceBetween(double price1, double price2);

}
