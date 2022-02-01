package com.cleverdeveloper.ws.soap.soapclient;

/*
PROJECT NAME : 9. Java SOAP Client
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 01/02/2022 23:24
*/

import com.cleverdeveloper.ws.soap.topdown.CustomerOrdersWebServiceImplService;
import com.cleverdeveloper.ws.trainings.*;
import com.diogonunes.jcolor.Attribute;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class CustomerOrderWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        // Coloring outputs
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(0, 0, 0);

        CustomerOrdersWebServiceImplService service = new CustomerOrdersWebServiceImplService(new URL("http://localhost:8080/wsdlfirstwebservice/customerordersservice?wsdl"));
        CustomerOrdersPortType customerOrdersPortType = service.getCustomerOrdersWebServiceImplPort();


        /* #### Starting #### Getting Orders Requests #### Starting ####  */
        GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
        getOrdersRequest.setCustomerId(BigInteger.valueOf(1));
        GetOrdersResponse getOrdersResponse = customerOrdersPortType.getOrders(getOrdersRequest);

        List<Order> orders = getOrdersResponse.getOrder();
        System.out.println(colorize("Number of orders of this customer are: " + orders.size(), BOLD(), textColor, backgroundColor));
        /* #### Ending #### Getting Orders Requests #### Ending ####  */

        /* #### Starting #### Creating Orders Requests #### Starting #### */
        CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
        createOrdersRequest.setCustomerId(BigInteger.valueOf(1));
        Order order = new Order();
        order.setId(BigInteger.valueOf(2));

        Product product = new Product();
        product.setId(String.valueOf(BigInteger.valueOf(3)));
        product.setDescription("Xiaomi Note 8 Pro");
        product.setQuantity(BigInteger.valueOf(4));
        order.getProduct().add(product);

        createOrdersRequest.setOrder(order);

        CreateOrdersResponse createOrdersResponse = customerOrdersPortType.createOrders(createOrdersRequest);
        System.out.println(colorize("Order created ? " + createOrdersResponse.isResult(), BOLD(), textColor, backgroundColor));
        /* #### Ending #### Creating Orders Requests #### Ending #### */
    }
}
