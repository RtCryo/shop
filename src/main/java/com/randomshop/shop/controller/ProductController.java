package com.randomshop.shop.controller;

import com.randomshop.shop.model.Product;
import com.randomshop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Product> productPage(
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.findProduct(id), HttpStatus.OK);
    }

}
