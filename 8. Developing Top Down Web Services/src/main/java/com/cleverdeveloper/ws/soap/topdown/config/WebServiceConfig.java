package com.cleverdeveloper.ws.soap.topdown.config;

/*
PROJECT NAME : 8. Developing Top Down Web Services
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 01/02/2022 22:01
*/

import com.cleverdeveloper.ws.soap.topdown.CustomerOrdersWebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWebServiceImpl());
        endpoint.publish("/customerordersservice");
        return endpoint;
    }
}
