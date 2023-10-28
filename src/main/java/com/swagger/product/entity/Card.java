package com.swagger.product.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Card {

    private static int ID_COUNTER = 0;
    private int id;
    private List<CardItem> cardItems;
    private User user;

    public Card() {
        id = ID_COUNTER++;
        cardItems= new ArrayList<>();
    }

}
