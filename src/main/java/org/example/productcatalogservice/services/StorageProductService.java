package org.example.productcatalogservice.services;

import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sps")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent())  return optionalProduct.get();

        return null;
     }

    @Override
    public Product createProduct(Product product) {
      return productRepo.save(product);
    }


//    public List<Product> getProductsBetweenRange(Double start,Double end) {
//        return productRepo.findProductByAmountBetween(start,end);
//    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
