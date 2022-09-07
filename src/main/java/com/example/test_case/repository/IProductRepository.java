package com.example.test_case.repository;

import com.example.test_case.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    //Trello #2
    List<Product> findAll();

    //Trello #8
    @Query(value = "select * from product where name like: name", nativeQuery = true)
    List<Product> findAllByNameContaining(@Param("name") String name);

    //Trello #3
    @Query(value = "select * from product where id like: id", nativeQuery = true)
    List<Product> findProductById(Long id);

    //Trello #4
    @Query(value = "select * from product where brand_id =:idb and category_id =:idc", nativeQuery = true)
    List<Product> findProductByFilter(@Param("idb") Long idb,@Param("idc") Long idc);

//    @Query(value = "select * from product where ")
}

