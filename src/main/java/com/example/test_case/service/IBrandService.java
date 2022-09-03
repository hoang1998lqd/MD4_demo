package com.example.test_case.service;

import com.example.test_case.model.Brand;

import java.util.List;
import java.util.Optional;

public interface IBrandService {
    List<Brand> findAll();
    Optional<Brand> findById(Long id);
    Brand save(Brand brand);
    void delete(Long id);
}
