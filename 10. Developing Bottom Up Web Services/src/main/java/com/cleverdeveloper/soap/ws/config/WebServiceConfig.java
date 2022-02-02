package com.cleverdeveloper.soap.ws.config;

/*
PROJECT NAME : 7. Apache CXF
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 01/02/2022 12:32
*/

import com.cleverdeveloper.soap.ws.PaymentProcessorImpl;
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
        // Make sure that you're importing the right Endpoint class
        Endpoint endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
        // this endpoint is available at the particular URL : /hello
        endpoint.publish("/hello");
        return endpoint;
    }
}
