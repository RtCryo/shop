package com.randomshop.shop.DTO;

import com.randomshop.shop.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ProductDTO {

    private long id;
    private String productName;
    private int valueInStock;
    private int price;
    private String description;
    private String imgName;
    private Category category;

}
