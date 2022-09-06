package com.example.test_case.controller;

import com.example.test_case.model.DTO.DTOProduct;
import com.example.test_case.model.ImageURL;
import com.example.test_case.model.Product;
import com.example.test_case.service.IProductService;
import com.example.test_case.service.ImageURLGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private IProductService iProduct;

    @Autowired
    private ImageURLGet imageURLGet;
    @GetMapping
    private ResponseEntity<List<DTOProduct>> findAll() {
        return new ResponseEntity<>(iProduct.getAllDTO(), HttpStatus.OK);
    }

    @GetMapping("/new-product")
    private ResponseEntity<?> findIdNewProduct() {
        return new ResponseEntity<>(iProduct.findIdNewProduct(), HttpStatus.OK);
    }

    @GetMapping("/image")
    private ResponseEntity<?> findAllImage() {
        return new ResponseEntity<>(imageURLGet.findAll(), HttpStatus.OK);
    }

    @GetMapping("/image/{id}")
    private ResponseEntity<?> findImageURLByProductId(@PathVariable Long id) {
        return new ResponseEntity<>(imageURLGet.findByProduct(id), HttpStatus.OK);
    }



    @PostMapping("/imageURL")
    private ResponseEntity<ImageURL> saveImage(@RequestBody ImageURL imageURL){
        return new ResponseEntity<>(imageURLGet.save(imageURL),HttpStatus.CREATED);
    }

    @PostMapping
    private ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(iProduct.save(product),HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteProduct( @PathVariable Long id){
        iProduct.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Optional<Product>optionalProduct = iProduct.findById(product.getId());
        if(optionalProduct.isPresent()){
            return new ResponseEntity<>(iProduct.save(product),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> getProduct( @PathVariable Long id){
        Optional<Product> product = iProduct.findById(id);
        if (product.isPresent()){
            return new ResponseEntity<>(product.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
