package com.example.test_case.service;

import com.example.test_case.model.ImageURL;


import java.util.List;
import java.util.Optional;

public interface ImageURLGet {
    List<String> findByProduct(Long id);
    List<ImageURL> findAll();
    Optional<ImageURL> findById(Long id);
    ImageURL save(ImageURL imageURL);
    void delete(Long id);
}
