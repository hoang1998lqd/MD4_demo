package com.example.test_case.controller;

import com.example.test_case.model.Category;
import com.example.test_case.model.Product;
import com.example.test_case.service.IBrandService;
import com.example.test_case.service.ICategoryService;
import com.example.test_case.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/products")
public class ProductController {

    @Autowired
    public IProductService productService;
    @Autowired
    public ICategoryService categoryService;
    @Autowired
    public IBrandService brandService;


//    Hiển thị tất cả sản phẩm
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }

//    Hiển thị loại sản phẩm
    @GetMapping("/categories")
    public ResponseEntity<Page<Category>> findAllCategories(Pageable pageable) {
        return new ResponseEntity<>(categoryService.findAll(pageable), HttpStatus.OK);
    }


//    Chi tiết 1 sản phẩm
    @GetMapping("/{id}")
    public ResponseEntity<Product> detail(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Tạo sản phẩm mới
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(product.getId());
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            productService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("search/{search}")
    public ResponseEntity<?> findByName(@PathVariable("search") String name, Pageable pageable) {
        Page<Product> productList = productService.findByName(name, pageable);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
