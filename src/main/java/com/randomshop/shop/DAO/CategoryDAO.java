package com.randomshop.shop.DAO;

import com.randomshop.shop.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDAO extends CrudRepository<Category, Long> {
    Category findByCategoryName(String name);
}
