package com.example.test_case.service;

<<<<<<< HEAD
import com.example.test_case.conmon.IGeneralService;
import com.example.test_case.model.Brand;

public interface IBrandService extends IGeneralService<Brand> {}
=======
import com.example.test_case.model.Brand;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBrandService {
    List<Brand> findAll();
    Optional<Brand> findById(Long id);
    Brand save(Brand brand);
    void delete(Long id);
    List<Brand> findBrandsByCategoryId(@Param("id")Long id);
}
>>>>>>> master
