package com.example.test_case.repository;

import com.example.test_case.model.ImageURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageURLRepository extends JpaRepository<ImageURL, Long> {
    @Query(value = " select imageurl.name from imageurl where product_id = ?1", nativeQuery = true)
    List<String> findImageURLByProductId(@Param("id")Long id);

}
