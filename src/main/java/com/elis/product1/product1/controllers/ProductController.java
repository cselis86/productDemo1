package com.elis.product1.product1.controllers;

import com.elis.product1.product1.entities.Product;
import com.elis.product1.product1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/createProduct")
    public long createProduct(){
        Product product = new Product();
        product.setName("lg");
        Product save = productRepository.save(product);

        return save.getId();
    }


    @GetMapping("/getProducts")
    public List<Product> getProducts(){

        return productRepository.findAll();
    }
}
