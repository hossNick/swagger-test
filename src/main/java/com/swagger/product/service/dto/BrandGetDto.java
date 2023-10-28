package com.swagger.product.service.dto;

import com.swagger.product.entity.Brand;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BrandGetDto {
    private int id;
    private String brandName;
    private LocalDate created_at;

    public BrandGetDto() {

    }

    public BrandGetDto(Brand brand) {
        id = brand.getId();
        brandName = brand.getName();
        created_at = brand.getCreatedAt();
    }
}

