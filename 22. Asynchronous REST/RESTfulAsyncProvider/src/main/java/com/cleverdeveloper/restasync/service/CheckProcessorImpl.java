package com.cleverdeveloper.restasync.service;

/*
PROJECT NAME : 22. Asynchronous REST
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 09/02/2022 18:54
*/

import com.cleverdeveloper.restasync.model.CheckList;

import javax.ws.rs.container.AsyncResponse;

public class CheckProcessorImpl implements CheckProcessor{

    @Override
    public void processChecks(AsyncResponse asyncResponse, CheckList checkList) {
        // Business Logic is here ...
        new Thread() {
            public void run() {
                asyncResponse.resume(true);
            }
        }.start();

    }
}
