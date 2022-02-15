package com.academicprogrammer.repository;

/*
PROJECT NAME : 28. REST and Database CRUD Operations
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 15/02/2022 14:11
*/

import com.academicprogrammer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
