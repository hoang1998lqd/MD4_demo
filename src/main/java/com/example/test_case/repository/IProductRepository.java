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
    Page<Product> findAll(Pageable pageable);

    //Trello #8
    @Query(value = "select * from product where name like: name", nativeQuery = true)
    Page<Product> findAllByNameContaining(@Param("name") String name, Pageable pageable);

    //Trello #3
    @Query(value = "select * from product where id like: id", nativeQuery = true)
    Page<Product> findProductById(Long id, Pageable pageable);

    //Trello #4
    @Query(value = "Select * from product where brand_id =:idb and category_id =:idc", nativeQuery = true)
    Page<Product> findProductByFilter(@Param("idb") Long idb,@Param("idc") Long idc, Pageable pageable);

}
