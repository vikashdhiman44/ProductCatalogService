package com.example.productcatalogservice.services;


import com.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
   List<Product> getAllProducts() ;

     Product getProductById(Long id) ;

     Product createProduct(Product product);
}
