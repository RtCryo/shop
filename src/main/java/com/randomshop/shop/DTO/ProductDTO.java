package com.randomshop.shop.DTO;

import com.randomshop.shop.model.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDTO {

    private long id;
    private String productName;
    private int valueInStock;
    private int price;
    private String description;
    private String imgName;
    private Category category;

}
