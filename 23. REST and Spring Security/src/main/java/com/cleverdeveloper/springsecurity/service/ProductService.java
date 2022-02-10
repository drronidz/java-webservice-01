package com.cleverdeveloper.springsecurity.service;

/*
PROJECT NAME : 23. REST and Spring Security
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 10/02/2022 22:12
*/

import com.cleverdeveloper.springsecurity.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/productservice")
public interface ProductService {

    @GET
    @Path("/products")
    List<Product> getProducts();

    @POST
    @Path("/products")
    Product addProduct(Product product);
}
