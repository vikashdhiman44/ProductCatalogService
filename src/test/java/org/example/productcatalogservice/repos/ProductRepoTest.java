package org.example.productcatalogservice.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repos.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    //@Test
    @Transactional
    public void testQueries() {
        //List<Product> productList = productRepo.findProductByAmountBetween(10000D,200000D);
//        List<Product> productList = productRepo.findProductByIsPrimeSpecificTrue();
//        for(Product product : productList) {
//            System.out.println(product.getDescription()+" "+product.getIsPrimeSpecific());
//        }

        String desc = productRepo.findCategoryNameFromProductId(5000L);
        System.out.println(desc);
    }

    @Test
    public void saveProducts() {
        Product product1 = new Product();
        product1.setTitle("Iphone");
        product1.setId(100L);
        product1.setDescription("latest Iphone");
        productRepo.save(product1);

        Product product2 = new Product();
        product2.setTitle("Macbook");
        product2.setId(1021L);
        product2.setDescription("latest mac");
        productRepo.save(product2);
    }

}