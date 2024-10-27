package org.example.productcatalogservice.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repos.CategoryRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

   /* @Test
    @Transactional
    public void testFetchTypes() {
        Category category = categoryRepo.findById(2L).get();
        for(Product product : category.getProducts()) {
            System.out.println(product.getDescription());
        }
    }*/


   // @Test
    @Transactional
    public void testFetchModesAndTypes() {
 //       Category category = categoryRepo.findByDescription("ewifhewih").get();
//        for(Product product : category.getProducts()) {
//            System.out.println(product.getDescription());
//        }
    }

   // @Test
    @Transactional
    public void runSubQueries() {
        List<Category> cats = categoryRepo.findAll();
        for(Category category : cats) {
            for(Product product :  category.getProducts()) {
                System.out.println(product.getDescription());
            }
        }
    }
}
