package com.cleverdeveloper.mtom;

/*
PROJECT NAME : 13. MTOM
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 02/02/2022 23:31
*/

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public interface FileWebService {
    void upload(@WebParam(name = "file") DataHandler attachment) throws IOException;
    DataHandler download();
}
