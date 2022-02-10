package com.cleverdeveloper.springsecurity.service;

/*
PROJECT NAME : 23. REST and Spring Security
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 10/02/2022 22:14
*/

import com.cleverdeveloper.springsecurity.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private List<Product> products = new ArrayList<>();
    private long id = 0;

    public ProductServiceImpl() {
        Product product = new Product();
        product.setId(++id);
        product.setDescription("Angular 6 Crash Course");
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        product.setId(++id);
        products.add(product);
        return product;
    }
}
