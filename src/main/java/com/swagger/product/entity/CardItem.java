package com.swagger.product.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardItem {

    private static int ID_COUNTER = 0;
    private int id;
    private Product product;
    private int count;

    public CardItem() {
        id = ID_COUNTER++;
    }

}
