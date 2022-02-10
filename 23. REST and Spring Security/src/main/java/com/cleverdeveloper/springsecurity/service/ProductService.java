package com.cleverdeveloper.springsecurity.service;

/*
PROJECT NAME : 23. REST and Spring Security
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 10/02/2022 22:12
*/

import com.cleverdeveloper.springsecurity.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product addProduct(Product product);
}
