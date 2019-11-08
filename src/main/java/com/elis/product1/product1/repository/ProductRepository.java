package com.elis.product1.product1.repository;

import com.elis.product1.product1.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Override
    Optional<Product> findById(Integer productId);

    @Override
    List<Product> findAll();

    @Query( value = "SELECT * FROM p_product ORDER BY created_date \n-- #pageable\n",
            nativeQuery = true)
    List<Product> getAllProducts();

    //    List<GetProductsRespDto> getProducts();
}
