package com.swagger.product.service.dto;

import com.swagger.product.entity.ProductGroup;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductGroupGetDto {
    private int id;
    private String name;
    private LocalDate created_at;

    public ProductGroupGetDto() {
    }

    public ProductGroupGetDto(ProductGroup productGroup) {
        id = productGroup.getId();
        name = productGroup.getName();
        created_at = productGroup.getCreatedAt();
    }
}
