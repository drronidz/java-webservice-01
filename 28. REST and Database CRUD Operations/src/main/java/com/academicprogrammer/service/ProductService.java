package com.academicprogrammer.service;

/*
PROJECT NAME : 28. REST and Database CRUD Operations
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 15/02/2022 14:16
*/

import com.academicprogrammer.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")
@Path("/productservice/products")
public interface ProductService {

    @Path("")
    @GET
    List<Product> getProducts();

    @Path("/{id}")
    @GET
    Product getProduct(@PathParam("id") int id);

    @Path("/new")
    @POST
    Response createProduct(Product product);

    @Path("/update")
    @PUT
    Response updateProduct(Product product);


}
