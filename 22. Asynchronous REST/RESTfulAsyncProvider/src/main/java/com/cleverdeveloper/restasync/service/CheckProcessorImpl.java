package com.cleverdeveloper.restasync.service;

/*
PROJECT NAME : 22. Asynchronous REST
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 09/02/2022 18:54
*/

import com.cleverdeveloper.restasync.model.CheckList;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;

@Service
public class CheckProcessorImpl implements CheckProcessor{

    @Override
    public void processChecks(AsyncResponse asyncResponse, CheckList checkList) {
        // Business Logic is here ...
        new Thread() {
            public void run() {
                if (checkList == null || checkList.getCheckList() == null || checkList.getCheckList().size() == 0) {
                    asyncResponse.resume(new BadRequestException());
                }
                asyncResponse.resume(true);
            }
        }.start();

    }
}
