package com.example.test_case.controller;

import com.example.test_case.model.Product;
import com.example.test_case.service.IProductService;
import com.example.test_case.model.DTO.DTOProduct;
import com.example.test_case.model.ImageURL;
import com.example.test_case.service.ImageURLGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/products")
public class ProductController {
    //<<<<<<< HEAD
//
//    @Autowired
//    public IProductService productService;
//    @Autowired
//    public ICategoryService categoryService;
//    @Autowired
//    public IBrandService brandService;
//
//
////    Hiển thị tất cả sản phẩm
//    @GetMapping
//    public ResponseEntity<Page<Product>> findAll( @PageableDefault (value = 10) Pageable pageable) {
//        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
//    }
//
////    Hiển thị loại sản phẩm
//    @GetMapping("/categories")
//    public ResponseEntity<Page<Category>> findAllCategories(@PageableDefault (value = 10) Pageable pageable) {
//        return new ResponseEntity<>(categoryService.findAll(pageable), HttpStatus.OK);
//    }
//
////    Chi tiết 1 sản phẩm
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> detail(@PathVariable("id") Long id) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (productOptional.isPresent()) {
//            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
////    Tạo sản phẩm mới
//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
//        Optional<Product> productOptional = productService.findById(product.getId());
//        if (productOptional.isPresent()) {
//            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (productOptional.isPresent()) {
//            productService.delete(id);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @GetMapping("search/{search}")
//    public ResponseEntity<?> findByName(@PathVariable("search") String name, Pageable pageable) {
//        Page<Product> productPage = productService.findByName(name, pageable);
//        if (productPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(productPage, HttpStatus.OK);
//    }
//}
//
//=======
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
    private ResponseEntity<ImageURL> saveImage(@RequestBody ImageURL imageURL) {
        return new ResponseEntity<>(imageURLGet.save(imageURL), HttpStatus.CREATED);
    }

    @PostMapping
    private ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(iProduct.save(product), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        iProduct.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> optionalProduct = iProduct.findById(product.getId());
        if (optionalProduct.isPresent()) {
            return new ResponseEntity<>(iProduct.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> product = iProduct.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/between-price")
    public ResponseEntity<?> findBetweenPrice(@RequestParam("min") Optional<Double> min
            , @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> products = iProduct.findProductByPriceBetween(minPrice, maxPrice);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find-all-categories/{id}")
    public ResponseEntity<?> findProductByCategories(@PathVariable Long id) {
        List<Product> products = iProduct.findProductByCategory(id);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}

