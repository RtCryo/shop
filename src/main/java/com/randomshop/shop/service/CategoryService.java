package com.randomshop.shop.service;

import com.randomshop.shop.DAO.CategoryDAO;
import com.randomshop.shop.DAO.ProductDAO;
import com.randomshop.shop.DTO.CategoryDTO;
import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Data
@Service
public class CategoryService {

    private final CategoryDAO categoryDAO;
    private final ProductDAO productDAO;

    public List<Category> listCategory(){
        return (List<Category>) categoryDAO.findAll();
    }

    public List<Product> listProductFromCategory(String category){
        return productDAO.findAllByCategory(categoryDAO.findByCategoryName(category));
    }

    public void categoryToDelete(CategoryDTO category) {
        categoryDAO.deleteCategoryByCategoryName(category.getCategoryName());
    }

    public void categoriesToDelete(List<Category> categories) { categoryDAO.deleteAll(categories); }

    public void categoryToSave(CategoryDTO category) {
        categoryDAO.save(dtoToModel(category));
    }

    public void categoryToUpdate(CategoryDTO category) {
        categoryDAO.updateCategory(category.getId(), category.getCategoryName());
    }

    private Category dtoToModel(CategoryDTO dto){
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        return category;
    }
}
