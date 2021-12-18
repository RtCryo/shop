package com.randomshop.shop.controller;

import com.randomshop.shop.model.Product;
import com.randomshop.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
