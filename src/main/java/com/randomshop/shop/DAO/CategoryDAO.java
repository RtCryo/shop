package com.randomshop.shop.DAO;

import com.randomshop.shop.model.Category;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategoryDAO extends CrudRepository<Category, Long> {
    Category findByCategoryName(String name);

    void deleteCategoryByCategoryName(String categoryName);
}
