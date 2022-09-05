package com.example.test_case.repository;

import com.example.test_case.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    //Trello #1
    @Query(value = "select * from category", nativeQuery = true)
    Page<Category> findAllCategory(Long id, Pageable pageable);
}
