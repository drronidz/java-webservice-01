package com.academicprogrammer.service;

/*
PROJECT NAME : 28. REST and Database CRUD Operations
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 15/02/2022 14:19
*/

import com.academicprogrammer.model.Product;
import com.academicprogrammer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Response createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return Response.ok(savedProduct).build();
    }

    @Override
    public Response updateProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return Response.ok(savedProduct).build();
    }

    @Override
    public Response deleteProductById(int id) {
        productRepository.deleteById(id);
        return Response.ok().build();
    }
}
