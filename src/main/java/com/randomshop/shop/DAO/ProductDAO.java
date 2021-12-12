package com.randomshop.shop.DAO;

import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductDAO extends PagingAndSortingRepository<Product, Long> {
    Product findProductById (Long id);

    @Query(value = "SELECT * FROM product order by random() LIMIT 10", nativeQuery = true)
    List<Product> randomListProduct();

    List<Product> findAllByCategory(Category category);

    void deleteProductByProductName(String productName);

    @Modifying
    @Query("update Product u set u.productName = :productName, u.valueInStock = :valueInStock, u.price = :price, " +
            "u.imgName = :imgName, u.description = :description, u.category = :category where u.id = :id")
    void updateProduct(@Param(value = "id") long id,
                       @Param(value = "productName") String productName,
                       @Param(value = "valueInStock") int valueInStock,
                       @Param(value = "price") int price,
                       @Param(value = "imgName") String imgName,
                       @Param(value = "description") String description,
                       @Param(value = "category") Category category);


}
