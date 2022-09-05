package com.example.test_case.conmon;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Long id);

    T save(T t);

    void delete(Long id);
}

