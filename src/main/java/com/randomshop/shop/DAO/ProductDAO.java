package com.randomshop.shop.DAO;

import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductDAO extends PagingAndSortingRepository<Product, Long> {
    Product findProductById (Long id);

    @Query(value = "SELECT * FROM product order by random() LIMIT 10", nativeQuery = true)
    List<Product> randomListProduct();

    List<Product> findAllByCategory(Category category);

    void deleteProductByProductName(String productName);
}
