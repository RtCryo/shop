package com.randomshop.shop.service;

import com.randomshop.shop.DAO.ProductDAO;
import com.randomshop.shop.DTO.ProductDTO;
import com.randomshop.shop.model.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductDAO productDAO;
    private final ImageStorageService imageStorageService;

    public List<Product> randomListProduct(){
        return productDAO.randomListProduct();
    }

    public Product findProduct(Long id){
        return productDAO.findProductById(id);
    }

    public List<Product> findAll(){
        return (List<Product>) productDAO.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void productToDelete(ProductDTO product) {
        if(!product.getImgName().equals("noimage.jpg")) {
            imageStorageService.deleteFile(product.getImgName());
        }
        productDAO.deleteProductByProductName(product.getProductName());
    }

    public void productsToDelete(List<Product> products) { productDAO.deleteAll(products); }

    public void productToSave(ProductDTO product) {
        productDAO.save(dtoToModel(product));
    }

    public void productToUpdate(ProductDTO productDTO) {
        Product newProduct = productDAO.findById(productDTO.getId()).map(product -> {
            product.setDescription(productDTO.getDescription());
            product.setCategory(productDTO.getCategory());
            product.setValueInStock(productDTO.getValueInStock());
            product.setPrice(productDTO.getPrice());
            product.setProductName(productDTO.getProductName());
            product.setImgName(productDTO.getImgName());
            return product;
        }).orElse(dtoToModel(productDTO));
        productDAO.save(newProduct);


//        productDAO.updateProduct(product.getId(), product.getProductName(), product.getValueInStock(), product.getPrice(),
//                product.getImgName(), product.getDescription(), product.getCategory());
    }

    private Product dtoToModel(ProductDTO product){
        Product productToSave = new Product();
        productToSave.setProductName(product.getProductName());
        productToSave.setImgName(product.getImgName());
        productToSave.setPrice(product.getPrice());
        productToSave.setValueInStock(product.getValueInStock());
        productToSave.setCategory(product.getCategory());
        productToSave.setDescription(product.getDescription());
        return productToSave;
    }

}

