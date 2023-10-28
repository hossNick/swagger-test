package com.swagger.product.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductGroup {

    private static int ID_COUNTER = 0;
    private int id;
    private String name;
    private LocalDate createdAt;

    public ProductGroup() {
        id = ID_COUNTER++;
        createdAt = LocalDate.now();
    }
}
