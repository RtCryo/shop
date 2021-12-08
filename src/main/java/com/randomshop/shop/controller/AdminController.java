package com.randomshop.shop.controller;

import com.randomshop.shop.model.Product;
import com.randomshop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> productsFromCategory(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }


}
