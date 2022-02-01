package com.cleverdeveloper.soap.webservice;

/*
PROJECT NAME : 7. Apache CXF
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 01/02/2022 12:17
*/

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldWebService {

    @WebMethod
    public String sayHelloWorld() {
        return "Hello World from HelloWorldWebService class";
    }
}
