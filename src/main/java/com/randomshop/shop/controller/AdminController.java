package com.randomshop.shop.controller;

import com.randomshop.shop.model.Product;
import com.randomshop.shop.service.ImageStorageService;
import com.randomshop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final ImageStorageService imageStorageService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> productsFromCategory(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/productsToDelete")
    public ResponseEntity<HttpStatus> productsToDelete(@RequestBody List<Product> productList){
        productService.productsToDelete(productList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/productToDelete")
    public ResponseEntity<HttpStatus> productToDelete(@RequestBody Product product){
        productService.deleteProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/productsToSave")
    public ResponseEntity<HttpStatus> productsToSave(@RequestBody Product product){
        productService.productToSave(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/imgToSave")
    public ResponseEntity<HttpStatus> imgToSave(@RequestParam("file") MultipartFile file){
        try {
            imageStorageService.save(file);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
