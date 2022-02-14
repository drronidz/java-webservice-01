package com.academicprogrammer.controller;

/*
PROJECT NAME : springrest
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 14/02/2022 17:19
*/

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class StockController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + " to the RESTful Spring World";
    }

    @RequestMapping(value = "/stockQuote/{firmName}", method = RequestMethod.GET)
    public StockQuoteResponse getStockQuote(@PathVariable String firmName) {
        StockQuoteResponse response = new StockQuoteResponse();
        response.setFirmName(firmName);
        response.setStockValue(1000);
        return  response;
    }
}
