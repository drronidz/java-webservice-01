package com.cleverdeveloper.mtom.config;

/*
PROJECT NAME : 13. MTOM
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 03/02/2022 00:02
*/

import com.cleverdeveloper.mtom.FileWebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new FileWebServiceImpl());
        endpoint.publish("/fileWebService");

        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
        binding.setMTOMEnabled(true);

        return endpoint;
    }
}
