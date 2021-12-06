package com.randomshop.shop.DAO;

import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDAO extends CrudRepository<Product, Long> {
    Product findProductById (Long id);

    @Query(value = "SELECT * FROM product order by random() LIMIT 10", nativeQuery = true)
    List<Product> randomListProduct();

    List<Product> findAllByCategory(Category category);
}
