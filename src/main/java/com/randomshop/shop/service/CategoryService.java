package com.randomshop.shop.service;

import com.randomshop.shop.DAO.CategoryDAO;
import com.randomshop.shop.DAO.ProductDAO;
import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Data
@Component
public class CategoryService {

    private final CategoryDAO categoryDAO;
    private final ProductDAO productDAO;

    public List<Category> listCategory(){
        return (List<Category>) categoryDAO.findAll();
    }

    public List<Product> listProductFromCategory(String category){
        return productDAO.findAllByCategory(categoryDAO.findByCategoryName(category));
    }
}
