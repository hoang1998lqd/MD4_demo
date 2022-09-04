package com.example.test_case.controller;

import com.example.test_case.model.Brand;
import com.example.test_case.model.Category;
import com.example.test_case.model.Product;
import com.example.test_case.service.IBrandService;
import com.example.test_case.service.ICategoryService;
import com.example.test_case.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    public IProductService productService;
    @Autowired
    public ICategoryService categoryService;
    @Autowired
    public IBrandService brandService;

    //Trello #1
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> findAllBrands() {
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.OK);
    }

    //Trello #2
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    //Trello #3
    @GetMapping("products/{id}")
    public ResponseEntity<Product> detail(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Trello #4
    @GetMapping("/products/search/{search}")
    public ResponseEntity<?> findProductByFilter(@PathVariable("search") Long id) {
        List<Product> productList = productService.findProductByFilter(id);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //CRUD
    @PostMapping("/products/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }
    //CRUD
    @PutMapping("/products/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(product.getId());
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //CRUD
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            productService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Trello #8
    @GetMapping("/products/search/{search}")
    public ResponseEntity<?> findByName(@PathVariable("search") String name) {
        List<Product> productList = productService.findByName(name);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
