package com.elis.product1.product1.service;

import com.elis.product1.product1.entities.dtos.product.find.GetProductsRespDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<GetProductsRespDto> getAllProducts();

}
