package com.swagger.product.service.dto;

import com.swagger.product.entity.Product;
import lombok.Data;

@Data
public class ProductGetDto {
    private int id;
    private BrandGetDto brand;
    private ProductGroupGetDto productGroup;
    private String name;

    public ProductGetDto() {
    }

    public ProductGetDto(Product product) {
        id = product.getId();
        name = product.getName();
        ;
        this.brand = new BrandGetDto(product.getBrand());
        this.productGroup = new ProductGroupGetDto(product.getProductGroup());
    }
}
