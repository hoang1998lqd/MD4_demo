package com.example.test_case.repository;

import com.example.test_case.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    //Trello #8
    List<Product> findAllByNameContaining(@Param("name") String name);

    //Trello #4
    @Query(value = "Select * from product where brand_id =:idb and category_id =:idc", nativeQuery = true)
    List<Product> findProductByFilter(@Param("idb") Long idb,@Param("idc") Long idc);

    List<Product> findAllByBrand_Id(Long id);
    List<Product> findAllByCategory_Id(Long id);
    List<Product> findAllByColor(String color);
    List<Product> findAllByPrice(double price);
}
