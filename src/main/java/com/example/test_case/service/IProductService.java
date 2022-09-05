package com.example.test_case.service;

import com.example.test_case.conmon.IGeneralService;
import com.example.test_case.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findByName(String name, Pageable pageable);
}
