package org.example.productcatalogservice.repos;

import org.example.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Page<Product> findProductByTitleEquals(String query, Pageable pageable);

    List<Product> findProductByAmountBetween(Double low, Double high);

    //List<Product> findProductByIsPrimeSpecific(Boolean value);
    List<Product>  findProductByIsPrimeSpecificTrue();

    @Query("SELECT p.description from Product p where p.id=?1")
    String findProductDesciptionFromProductId(Long id);


    @Query("SELECT c.name from Category c join Product p on p.category.id=c.id where p.id=:productId")
    String findCategoryNameFromProductId(Long productId);
}
