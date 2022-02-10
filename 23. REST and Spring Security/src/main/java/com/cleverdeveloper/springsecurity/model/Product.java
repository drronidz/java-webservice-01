package com.cleverdeveloper.springsecurity.model;

/*
PROJECT NAME : 23. REST and Spring Security
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 10/02/2022 22:11
*/

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Product {

    private long id;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
