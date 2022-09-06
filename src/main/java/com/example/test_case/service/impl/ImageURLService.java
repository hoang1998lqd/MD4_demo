package com.example.test_case.service.impl;

import com.example.test_case.model.ImageURL;
import com.example.test_case.repository.ImageURLRepository;
import com.example.test_case.service.ImageURLGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ImageURLService implements ImageURLGet {
    @Autowired
    private ImageURLRepository imageURLRepository;
    @Override
    public List<String> findByProduct(Long id) {
        return imageURLRepository.findImageURLByProductId(id);
    }

    @Override
    public List<ImageURL> findAll() {
        return imageURLRepository.findAll();
    }

    @Override
    public Optional<ImageURL> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ImageURL save(ImageURL imageURL) {
        return imageURLRepository.save(imageURL);
    }

    @Override
    public void delete(Long id) {

    }
}
