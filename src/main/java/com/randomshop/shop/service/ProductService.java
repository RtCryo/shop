package com.randomshop.shop.service;

import com.randomshop.shop.DAO.ProductDAO;
import com.randomshop.shop.model.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@RequiredArgsConstructor
@Component
public class ProductService {

    private final ProductDAO productDAO;

    public List<Product> randomListProduct(){
        return productDAO.randomListProduct();
    }

    public Product findProduct(Long id){
        return productDAO.findProductById(id);
    }
}
