package com.elis.product1.product1;

import com.elis.product1.product1.controllers.ProductRepoController;
import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import com.elis.product1.product1.entities.dtos.product.update.UpdateProductReq;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductRepoController rc ;
    private EntityManager em;

    @BeforeEach
    void setUp() {

    }

    @Test
    void create() {
        CreateProductDto dto = new CreateProductDto();
        dto.setName("ProdRC-" + RandomString.make(2));
        dto.setType(1);
        rc.create(dto);
    }

    @Test
    void update() {
        UpdateProductReq dto = new UpdateProductReq();
        dto.setId(1);
        dto.setName("ProdRC-" + RandomString.make(2));
        dto.setType(1);
        rc.update(dto);
    }

    @Test
    void delete() {

        rc.delete(2);
    }

    @Test
    void findAll() {
        rc.find();
    }

    @Test
    void findById() {
        rc.findById(1);
    }
}
