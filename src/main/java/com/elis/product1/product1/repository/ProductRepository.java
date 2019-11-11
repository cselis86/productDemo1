package com.elis.product1.product1.repository;

import com.elis.product1.product1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Override
    Optional<Product> findById(Integer productId);

    @Override
    List<Product> findAll();

    @Query( value = "SELECT * FROM p_product ORDER BY created_date \n-- #pageable\n",
            nativeQuery = true)
    List<Product> getAllProducts();






    //    List<GetProductsRespDto> getProducts();
}
