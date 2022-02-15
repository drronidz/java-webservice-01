package com.academicprogrammer.model;

/*
PROJECT NAME : 28. REST and Database CRUD Operations
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 15/02/2022 14:07
*/

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private String description;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
