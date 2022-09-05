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
    @GetMapping("/{id}")
    public ResponseEntity<Product> detail(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Trello #4
    @GetMapping("/search/{search}")
    public ResponseEntity<?> findProductByFilter(@PathVariable("search") Long id) {
        List<Product> productList = productService.findProductByFilter(id);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //CRUD
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }
    //CRUD
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(product.getId());
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //CRUD
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            productService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Trello #8
    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        List<Product> productList = productService.findByName(name);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand_id}")
    public ResponseEntity<?> findAllByBrand(@PathVariable("brand_id") Long id) {
        List<Product> productList = productService.findAllByBrand_Id(id);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<?> findAllByCategory(@PathVariable("category_id") Long id) {
        List<Product> productList = productService.findAllByCategory_Id(id);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<?> findAllByColor(@PathVariable("color") String color) {
        List<Product> productList = productService.findAllByColor(color);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/price/{search}")
    public ResponseEntity<?> findAllByPrice(@PathVariable("search") double price){
        List<Product> productList = productService.findAllByPrice(price);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }


}
