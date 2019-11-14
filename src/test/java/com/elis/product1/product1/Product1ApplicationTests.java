package com.elis.product1.product1;

import com.elis.product1.product1.controllers.ProductController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;


@SpringBootTest
class Product1ApplicationTests {

   @Autowired
   private ProductController c;

    @Autowired
    private EntityManager em;

    @BeforeEach
    void setUp() {

    }

    @Test
    void contextLoads() {
    }

//    @Test
//    void getProducts() {
//
//        c.getProducts();
//    }
//
//    @Test
//    void creatProduct(){
//        CreateProductDto dto = new CreateProductDto();
//        dto.setName("Prod-" + RandomString.make(2));
//        dto.setType(1);
//        c.createProduct(dto);
//    }
//
//    @Test
//    void updateProduct() {
//        UpdateProductReq req = new UpdateProductReq();
//
//        req.setId(2);
//        req.setName("Update_prod_" + RandomString.make(2));
//        req.setType(2);
//
//        c.updateProduct(req.getId(), req);
//    }
//
//    @Test
//    void findProductsOptionPaging() {
//
//        FindProductsReq req = new FindProductsReq();
//
//        req.setFilter("to");
//        req.setOffset(10);
//
//        c.findProductsPage(req);
//    }
}
