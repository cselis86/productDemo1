package com.elis.product1.product1.service;

import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import com.elis.product1.product1.entities.dtos.product.find.GetProductsRespDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.elis.product1.product1.entities.QProduct.product;

@Service
public class ProductServiceImpl  {

    protected EntityManager em;
    protected JPAQueryFactory jpaQuery;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public void setJpaQuery(JPAQueryFactory jpaQuery) {
        this.jpaQuery = jpaQuery;
    }

    public List<GetProductsRespDto> getAllProducts() {

        List<GetProductsRespDto> resp = jpaQuery.select(Projections.bean(GetProductsRespDto.class,
                product.id,
                product.createdDate,
                product.name,
                product.type
        )).from(product).fetch();
        return resp;
    }

    public Integer createProduct(CreateProductDto dto) {

        return null;

    }
}
