package com.academicdeveloper.client;/*
PROJECT NAME : 26. Jersey Quick Start
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 14/02/2022 14:25
*/

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class JerseyClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String result = client.target("http://localhost:8080/jerseyws/restapi/helloworld").request().get(String.class);
        System.out.println(result);
    }
}
