package com.example.test_case.service;

import com.example.test_case.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category Category);
    void delete(Long id);
}
