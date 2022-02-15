package com.academicprogrammer.service;

/*
PROJECT NAME : 28. REST and Database CRUD Operations
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 15/02/2022 14:16
*/

import com.academicprogrammer.model.Product;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(int id);

    Response createProduct(Product product);

    Response updateProduct(Product product);


}
