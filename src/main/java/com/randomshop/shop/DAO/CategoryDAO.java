package com.randomshop.shop.DAO;

import com.randomshop.shop.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CategoryDAO extends CrudRepository<Category, Long> {
    Category findByCategoryName(String name);

    @Modifying
    @Query("update Category u set u.categoryName = :categoryName where u.id = :id")
    void updateCategory(@Param(value = "id") long id,
                       @Param(value = "categoryName") String categoryName);

    void deleteCategoryByCategoryName(String categoryName);
}
