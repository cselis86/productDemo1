package com.elis.product1.product1.service;

import com.elis.product1.product1.entities.Product;
import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import com.elis.product1.product1.entities.dtos.product.find.GetProductsRespDto;
import com.elis.product1.product1.entities.dtos.product.update.UpdateProductReq;
import com.elis.product1.product1.repository.ProductRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

import static com.elis.product1.product1.entities.QProduct.product;
import static com.elis.product1.product1.mappers.ProductMapper.PRODUCT_MAPPER;

@Service
public class ProductServiceImpl  {

    protected EntityManager em;
    protected JPAQueryFactory jpaQuery;

    @Autowired
    ProductRepository repository;

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

        Product product = PRODUCT_MAPPER.toProduct(dto);
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        em.persist(product);
        Integer id = product.getId();

        return id;

    }

    public int updateProduct(Integer id, UpdateProductReq req) {

        Product product = em.find(Product.class, id);
        PRODUCT_MAPPER.toUpdateProduct(req, product);
        em.merge(product);

        return product.getId();
    }

    public List<Product> findAllPag(){

        Product product = new Product();
        product.setName("tob");


        List<Product> all = repository.findAll(Example.of(product));

        return all;
    }
}
