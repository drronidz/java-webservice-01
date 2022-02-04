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
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        // Make sure that you're importing the right Endpoint class
        EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
        // this endpoint is available at the particular URL : /hello
        endpoint.publish("/paymentProcessor");

        return endpoint;
    }
}
