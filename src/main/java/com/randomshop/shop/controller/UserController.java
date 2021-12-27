package com.randomshop.shop.controller;

import com.randomshop.shop.DTO.UserDTO;
import com.randomshop.shop.model.Product;
import com.randomshop.shop.service.ProductService;
import com.randomshop.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@PreAuthorize("hasAuthority('user:read')")
public class UserController {

    private final UserService userService;
    private final ProductService productService;

    @PostMapping("/updateUser")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/getAllProductsById")
    public ResponseEntity<List<Product>> getAllProductsById(@RequestBody List<Long> listId){
        return new ResponseEntity<>(productService.getAllProductsById(listId),HttpStatus.OK);
    }

    @PostMapping("/findUserProfileByEmail")
    public ResponseEntity<UserDTO> userProfileByEmail(@RequestBody String userEmail){
        return new ResponseEntity<>(userService.findUserProfileByEmail(userEmail),HttpStatus.OK);
    }

}
