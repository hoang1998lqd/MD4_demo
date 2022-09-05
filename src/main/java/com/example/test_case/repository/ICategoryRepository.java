package com.example.test_case.repository;

import com.example.test_case.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
