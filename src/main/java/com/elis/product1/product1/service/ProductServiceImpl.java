package com.elis.product1.product1.service;

import com.elis.product1.product1.commons.paging.PageResp;
import com.elis.product1.product1.commons.validation.Validator;
import com.elis.product1.product1.entities.Product;
import com.elis.product1.product1.entities.QProduct;
import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import com.elis.product1.product1.entities.dtos.product.find.FindProductDto;
import com.elis.product1.product1.entities.dtos.product.find.FindProductsReq;
import com.elis.product1.product1.entities.dtos.product.find.GetProductsRespDto;
import com.elis.product1.product1.entities.dtos.product.update.UpdateProductReq;
import com.elis.product1.product1.repository.ProductRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import static com.elis.product1.product1.entities.QProduct.product;
import static com.elis.product1.product1.mappers.ProductMapper.PRODUCT_MAPPER;

@Service
public class ProductServiceImpl extends SortableService {

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

    public PageResp<FindProductDto> findProductsPage(FindProductsReq req) {

        QProduct product = QProduct.product;
        BooleanBuilder bb = new BooleanBuilder();


        if (Validator.hasValue(req.getFrom())){
            bb.and(product.createdDate.goe(req.getFrom()));
        }

        if (Validator.hasValue(req.getTo())){
            bb.and(product.createdDate.loe(req.getTo()));
        }

        if (Validator.hasValue(req.getType())){
            bb.and(product.type.eq(req.getType()));
        }

        if (Validator.hasValue(req.getIds())){
            bb.and(product.id.in(req.getIds()));
        }

        if (Validator.hasValue(req.getFilter())){
            bb.and(product.name.containsIgnoreCase(req.getFilter()));
        }

        List<Integer> ids = jpaQuery.select(product.id).from(product).where(bb).fetch();

        if (ids.isEmpty()){
            return PageResp.EMPTY;
        }

        OrderSpecifier<String> defaultOrder = product.name.desc();

        HashMap<Object, Object> orderColumns = new HashMap<>();
        orderColumns.put("id",product.id);
        orderColumns.put("name",product.name);
        orderColumns.put("type",product.type);

        List<FindProductDto> res = jpaQuery.select(Projections.bean(FindProductDto.class,
                product.id,
                product.name,
                product.type
        ))
                .from(product)
                .where(bb)
                .offset(req.getOffset())
                .limit(req.getLimit())
                .orderBy(orderBy(req, defaultOrder))
                .fetch();


        return PageResp.of(ids.size(), res);
    }
}
