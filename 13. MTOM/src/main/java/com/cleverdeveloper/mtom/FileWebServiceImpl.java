package com.cleverdeveloper.mtom;

/*
PROJECT NAME : 13. MTOM
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 02/02/2022 23:46
*/

import javax.activation.DataHandler;
import java.io.*;

public class FileWebServiceImpl implements FileWebService{
    @Override
    public void upload(DataHandler attachment) throws IOException {
        InputStream inputStream = attachment.getInputStream();
        OutputStream outputStream = new FileOutputStream(new File("C:/Users/DRRONIDZ/IdeaProjects/Java Vanilla/java-webservice-01/13. MTOM/uploaded/spring.jpg"));

        byte[] bytes = new byte[10000];
        int bytesRead = 0;

        while ((bytesRead = inputStream.read(bytes))!= -1) {
            outputStream.write(bytes, 0, bytesRead);
        }
    }

    @Override
    public DataHandler download() {
        return null;
    }
}
