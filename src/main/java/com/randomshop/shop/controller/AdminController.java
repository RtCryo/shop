package com.randomshop.shop.controller;

import com.randomshop.shop.DTO.CategoryDTO;
import com.randomshop.shop.DTO.MessageDTO;
import com.randomshop.shop.DTO.ProductDTO;
import com.randomshop.shop.DTO.SiteSettingDTO;
import com.randomshop.shop.model.Category;
import com.randomshop.shop.model.Product;
import com.randomshop.shop.model.SiteSetting;
import com.randomshop.shop.service.CategoryService;
import com.randomshop.shop.service.ImageStorageService;
import com.randomshop.shop.service.ProductService;
import com.randomshop.shop.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ImageStorageService imageStorageService;
    private final SiteService siteService;

    ////< Admin product
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
    public ResponseEntity<HttpStatus> productToDelete(@RequestBody ProductDTO product){
        productService.productToDelete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/productToSave")
    public ResponseEntity<HttpStatus> productsToSave(@RequestBody ProductDTO product){
        productService.productToSave(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/productToUpdate")
    public ResponseEntity<HttpStatus> productsToUpdate(@RequestBody ProductDTO product){
        productService.productToUpdate(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/imgToSave")
    public ResponseEntity<MessageDTO> imgToSave(@RequestParam("file") MultipartFile file){
        String message;
        try {
            message = imageStorageService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageDTO(message));
        }
    }
    /////Admin product >

    /////< Admin category
    @PostMapping("/categoriesToDelete")
    public ResponseEntity<HttpStatus> categoriesToDelete(@RequestBody List<Category> categoryList){
        categoryService.categoriesToDelete(categoryList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/categoryToDelete")
    public ResponseEntity<HttpStatus> categoryToDelete(@RequestBody CategoryDTO category){
        categoryService.categoryToDelete(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/categoryToSave")
    public ResponseEntity<HttpStatus> categoryToSave(@RequestBody CategoryDTO category){
        categoryService.categoryToSave(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/categoryToUpdate")
    public ResponseEntity<HttpStatus> categoryToUpdate(@RequestBody CategoryDTO category){
        categoryService.categoryToUpdate(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /////Admin category >

    /////Site settings
    @GetMapping("/settings")
    public ResponseEntity<SiteSetting> settings(){
        return new ResponseEntity<>(siteService.getSettings(), HttpStatus.OK);
    }

    @PostMapping("/updateSettings")
    public ResponseEntity<HttpStatus> updateSettings(@RequestBody SiteSettingDTO siteSetting){
        siteService.updateSiteSettings(siteSetting);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/imgSiteToSave")
    public ResponseEntity<MessageDTO> imgSiteToSave(@RequestParam("file") MultipartFile file){
        String message;
        try {
            message = imageStorageService.saveSiteImg(file);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageDTO(message));
        }
    }

    @PostMapping("/logoToSave")
    public ResponseEntity<MessageDTO> logoToSave(@RequestParam("file") MultipartFile file){
        String message;
        try {
            message = imageStorageService.saveSiteLogo(file);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageDTO(message));
        }
    }
}
