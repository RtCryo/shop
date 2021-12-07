package com.randomshop.shop.controller;

import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import com.randomshop.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<List<Product>> productsFromCategory(@RequestBody String category){
        return new ResponseEntity<>(categoryService.listProductFromCategory(category), HttpStatus.OK);
    }

}
