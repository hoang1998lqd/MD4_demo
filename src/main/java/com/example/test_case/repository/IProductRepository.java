package com.example.test_case.repository;

import com.example.test_case.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContaining(String name);
    List<Product> findAllByCategory(Long id);
    List<Product> findAllByBrand(Long id);
}
