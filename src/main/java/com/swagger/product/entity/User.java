package com.swagger.product.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private static int ID_COUNTER = 0;
    private int id;
    private String name;
    private String lastName;
    private int age;

    public User() {
        id = ID_COUNTER++;
    }
}
