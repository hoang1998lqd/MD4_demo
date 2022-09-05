package com.example.test_case.service.impl;

import com.example.test_case.model.Product;
import com.example.test_case.repository.IProductRepository;
import com.example.test_case.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    public IProductRepository productRepository;
    @Override
    public List<Product> findProductByFilter(Long id) {
        return productRepository.findProductByFilter(id, id);
    }

    @Override
    public List<Product> findAllByBrand_Id(Long id) {
        return productRepository.findAllByBrand_Id(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAllByNameContaining(name);
    }


    @Override
    public List<Product> findAllByCategory_Id(Long id) {
        return productRepository.findAllByCategory_Id(id);
    }

    @Override
    public List<Product> findAllByColor(String color) {
        return productRepository.findAllByColor(color);
    }

    @Override
    public List<Product> findAllByPrice(double price) {
        return productRepository.findAllByPrice(price);
    }
}
