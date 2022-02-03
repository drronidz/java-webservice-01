package com.cleverdeveloper.ws.soap.topdown.config;

/*
PROJECT NAME : 8. Developing Top Down Web Services
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 01/02/2022 22:01
*/

import com.cleverdeveloper.ws.soap.topdown.CustomerOrdersWebServiceImpl;
import handlers.SiteHandler;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;
import java.util.ArrayList;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWebServiceImpl());
        endpoint.publish("/customerordersservice");

        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
        ArrayList<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new SiteHandler());

        binding.setHandlerChain(handlerChain);

        return endpoint;
    }
}
