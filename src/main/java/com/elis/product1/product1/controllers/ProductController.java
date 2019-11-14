package com.elis.product1.product1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

//    private ProductServiceImpl productService;
//
//    @GetMapping
//    public List<GetProductsRespDto> getProducts(){
//
//        return productService.getAllProducts();
//    }
//
//    @PostMapping
//    @Transactional
//    public Integer createProduct(@Valid @RequestBody CreateProductDto dto) {
//
//        Integer id = productService.createProduct(dto);
//
//        return id;
//    }
//
//    @PutMapping("/{id}")
//    @Transactional
//    public Integer updateProduct(@PathVariable Integer id, @Valid @RequestBody UpdateProductReq req) {
//
//        int resp = productService.updateProduct(id, req);
//
//        return resp;
//    }
//
//    @PostMapping("/findProduct")
//    public PageResp<FindProductDto> findProductsPage(@Valid @RequestBody FindProductsReq req) {
//        return productService.findProductsPage(req);
//    }



}
