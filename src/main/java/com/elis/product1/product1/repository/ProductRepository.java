package com.elis.product1.product1.repository;

import com.elis.product1.product1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long productId);

    @Override
    List<Product> findAll();
}
