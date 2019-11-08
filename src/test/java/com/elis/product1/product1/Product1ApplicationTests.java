package com.elis.product1.product1;

import com.elis.product1.product1.controllers.ProductController;
import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.sql.Timestamp;


@SpringBootTest
class Product1ApplicationTests {
    @Autowired
    ProductController c;

    @Autowired
    EntityManager em;

    @BeforeEach
    void setUp() {

    }

    @Test
    void contextLoads() {
    }

    @Test
    void getProducts() {

        c.getProducts();
    }

    @Test
    void creatProduct(){
        CreateProductDto dto = new CreateProductDto();
        dto.setName("tobleron");
        dto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        dto.setType(1);
        c.createProduct(dto);
    }
}
