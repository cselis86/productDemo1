package com.elis.product1.product1.controllers;

import com.elis.product1.product1.entities.Product;
import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import com.elis.product1.product1.entities.dtos.product.update.UpdateProductReq;
import com.elis.product1.product1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.elis.product1.product1.mappers.ProductMapper.PRODUCT_MAPPER;

@RestController
@RequestMapping("/repo/products")
public class ProductRepoController {

    @Autowired
    private ProductRepository repoJpa;


    @PostMapping()
    @ResponseStatus()
    public int create(@Valid @RequestBody CreateProductDto dto){
        Product product = PRODUCT_MAPPER.toProduct(dto);
        Product save = repoJpa.save(product);

        return save.getId();
    }

    @PutMapping
    public int update(@Valid @RequestBody UpdateProductReq req){
        Product product = new Product();
        PRODUCT_MAPPER.toUpdateProduct(req, product);

        Product rsp = repoJpa.save(product);

        return rsp.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        Product product = repoJpa.findById(id).orElse(null);
        if (product != null){
            repoJpa.delete(product);
        }
    }

    @GetMapping("/findProducts")
    public List<Product> find(){

        List<Product> resp = repoJpa.findAll();

        return resp;
    }

    @GetMapping("/findProduct/{id}")
    public Product findById(@PathVariable Integer id){

        return repoJpa.findById(id).orElse(null);
    }
}
