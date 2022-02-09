package com.cleverdeveloper.restasync.service;

/*
PROJECT NAME : 22. Asynchronous REST
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 09/02/2022 18:51
*/

import com.cleverdeveloper.restasync.model.CheckList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("/checkprocessingservice")
public interface CheckProcessor {

    @POST
    @Path("/checklist")
    public void processChecks(@Suspended AsyncResponse asyncResponse, CheckList checkList);
}
