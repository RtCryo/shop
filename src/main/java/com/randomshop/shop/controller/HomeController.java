package com.randomshop.shop.controller;

import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import com.randomshop.shop.service.CategoryService;
import com.randomshop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/home")
public class HomeController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public @ResponseBody ResponseEntity<HttpStatus> homePage(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/product")
    public @ResponseBody ResponseEntity<List<Product>> homePageRandomProduct(){
        return new ResponseEntity<>(productService.randomListProduct(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public @ResponseBody ResponseEntity<List<Category>> homePageCategory(){
        return new ResponseEntity<>(categoryService.listCategory(), HttpStatus.OK);
    }

}
