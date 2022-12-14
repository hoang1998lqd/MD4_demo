package com.example.test_case.service.impl;

import com.example.test_case.model.DTO.DTOProduct;
import com.example.test_case.model.ImageURL;
import com.example.test_case.model.Product;
import com.example.test_case.service.IProductService;
import com.example.test_case.service.ImageURLGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Service
public class DTOProductService {
    @Autowired
    private ImageURLGet imageURLGet;
    @Autowired
    private IProductService iProductService;

    private List<ImageURL>getImageURLS (){
        return imageURLGet.findAll();
    }
    private List<Product> getAllProduct(){
        return iProductService.findAll();
    }

    public List<DTOProduct> createDtoProducts (){
        List<DTOProduct> dtoProducts = new ArrayList<>();
        ArrayList<Product> products = (ArrayList<Product>) getAllProduct();
        ArrayList<ImageURL> imageURLS = (ArrayList<ImageURL>) getImageURLS();
        for (Product product : products){
            DTOProduct dtoProduct= null;
            ArrayList<String> imageURLSProduct = new ArrayList<>();
            for (ImageURL imageURL : imageURLS){
                if (Objects.equals(imageURL.getProduct().getId(), product.getId())){
                    imageURLSProduct.add(imageURL.getName());
                }
                dtoProduct = new DTOProduct(product,imageURLSProduct);
            }
            dtoProducts.add(dtoProduct);
        }
        return dtoProducts;
    }

}
