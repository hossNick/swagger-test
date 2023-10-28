package com.swagger.product.service.dto;

import lombok.Data;

@Data
public class ProductPostDto {
    private String name;
    private int brandId;
    private int ProductGroupId;
}
