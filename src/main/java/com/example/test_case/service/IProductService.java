package com.example.test_case.service;

<<<<<<< HEAD
import com.example.test_case.conmon.IGeneralService;
=======
import com.example.test_case.model.DTO.DTOProduct;
>>>>>>> master
import com.example.test_case.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

<<<<<<< HEAD
public interface IProductService extends IGeneralService<Product> {
    Page<Product> findByName(String name, Pageable pageable);
=======
import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
    Long findIdNewProduct();
    List<DTOProduct> getAllDTO();
>>>>>>> master
}
