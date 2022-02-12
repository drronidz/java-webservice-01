package com.academicprogramming;

/*
PROJECT NAME : 25. REST Attachments
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/02/2022 15:27
*/


import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileClient {
    public static void main(String[] args) throws FileNotFoundException {

        WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
        client.type("multipart/form-data");
        ContentDisposition contentDisposition = new ContentDisposition("attachment;filename=MAVEN.PNG");

        Attachment attachment = new Attachment("root", new FileInputStream(new File("C:\\Users\\DRRONIDZ\\IdeaProjects\\Java Vanilla\\java-webservice-01\\25. REST Attachments\\docs\\images\\2.png")), contentDisposition);
        client.post(attachment);
    }
}
