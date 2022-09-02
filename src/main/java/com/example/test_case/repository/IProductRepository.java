package com.example.test_case.repository;

import com.example.test_case.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product where name like: name", nativeQuery = true)
    List<Product> findAllByNameContaining(@Param("name") String name);
    @Query(value = "select * from category where id like: id", nativeQuery = true)
    List<Product> findAllByCategory(Long id);

    @Query(value = "select * from brand where id like: id", nativeQuery = true)
    List<Product> findAllByBrand(Long id);

    @Query(value = "select * from product where id like: id", nativeQuery = true)
    List<Product> findProductById(Long id);

    @Query(value = "select * from product where brand_id like: brand_id", nativeQuery = true)
    List<Product> findProductByBrandId(Long id);

    @Query(value = "select * from product where category_id like: category_id", nativeQuery = true)
    List<Product> findProductByCategoryId(Long id);


}
