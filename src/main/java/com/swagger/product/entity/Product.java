package com.swagger.product.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@Component
public class Product {

    private static int ID_COUNTER = 0;
    private int id;
    private String name;
    private Brand brand;
    private ProductGroup productGroup;
    private LocalDate createdAt;

    public Product() {
        id = ID_COUNTER++;
        createdAt = LocalDate.now();
    }
}