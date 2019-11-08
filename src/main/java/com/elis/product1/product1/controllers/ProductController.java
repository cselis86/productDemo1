package com.elis.product1.product1.controllers;

import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import com.elis.product1.product1.entities.dtos.product.find.GetProductsRespDto;
import com.elis.product1.product1.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private ProductServiceImpl productService;

    @GetMapping
    public List<GetProductsRespDto> getProducts(){

        return productService.getAllProducts();
    }

    @PostMapping
    @Transactional
    public @ResponseBody Integer createProduct(@Valid @RequestBody CreateProductDto dto) {

        productService.createProduct(dto);

        return null;
    }
}
