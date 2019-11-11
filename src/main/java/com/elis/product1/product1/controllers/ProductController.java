package com.elis.product1.product1.controllers;

import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import com.elis.product1.product1.entities.dtos.product.find.GetProductsRespDto;
import com.elis.product1.product1.entities.dtos.product.update.UpdateProductReq;
import com.elis.product1.product1.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private ProductServiceImpl productService;

    @GetMapping
    public List<GetProductsRespDto> getProducts(){

        return productService.getAllProducts();
    }

    @PostMapping
    @Transactional
    public Integer createProduct(@Valid @RequestBody CreateProductDto dto) {

        Integer id = productService.createProduct(dto);

        return id;
    }

    @PutMapping("/{id}")
    @Transactional
    public Integer updateProduct(@PathVariable Integer id, @Valid @RequestBody UpdateProductReq req) {

        int resp = productService.updateProduct(id, req);

        return resp;
    }
}
