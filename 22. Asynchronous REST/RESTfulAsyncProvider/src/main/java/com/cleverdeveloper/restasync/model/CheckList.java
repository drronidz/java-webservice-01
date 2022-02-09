package com.cleverdeveloper.restasync.model;

/*
PROJECT NAME : 22. Asynchronous REST
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 09/02/2022 18:52
*/

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CheckList {

    private List<Check> checkList;

    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }
}
