package com.cleverdeveloper.ws.soap.topdown;

/*
PROJECT NAME : 8. Developing Top Down Web Services
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 01/02/2022 21:18
*/

import com.cleverdeveloper.ws.trainings.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerOrdersWebServiceImpl implements CustomerOrdersPortType {

    Map<BigInteger, List<Order>> customerOrders = new HashMap<>();

    // Act like a primary key column (in each creation, we increment it)
    int currentId = 0;

    public CustomerOrdersWebServiceImpl() {
        init();
    }

    public void init() {
        List<Order> orders = new ArrayList<>();

        Order order = new Order();
        order.setId(BigInteger.valueOf(1));

        Product product = new Product();
        product.setId(String.valueOf(1));
        product.setDescription("ThinkPad X260");
        product.setQuantity(BigInteger.valueOf(3));

        order.getProduct().add(product);

        orders.add(order);

        customerOrders.put(BigInteger.valueOf(++currentId), orders);

    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest parameters) {
        return null;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest parameters) {
        return null;
    }
}
