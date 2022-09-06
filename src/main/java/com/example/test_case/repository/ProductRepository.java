package com.example.test_case.repository;

import com.example.test_case.model.Brand;
import com.example.test_case.model.Product;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Repository
@EnableSpringConfigured
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select max(id) from product",
            nativeQuery = true)
    Long findIdNewProduct();

    List<Product> findProductByPriceBetween(double price1, double price2);

}
