package com.academicdeveloper;

/*
PROJECT NAME : 26. Jersey Quick Start
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 14/02/2022 14:19
*/

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("helloworld")
public class HelloWorld {

    @GET
    public String hello() {
        return "Hello World from Jersey";
    }
}
