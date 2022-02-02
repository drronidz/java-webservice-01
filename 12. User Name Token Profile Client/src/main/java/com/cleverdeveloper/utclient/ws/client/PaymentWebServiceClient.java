package com.cleverdeveloper.utclient.ws.client;

/*
PROJECT NAME : 12. User Name Token Profile Client
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 02/02/2022 21:30
*/

import com.cleverdeveloper.soap.ws.PaymentProcessor;
import com.cleverdeveloper.soap.ws.PaymentProcessorImplService;
import com.cleverdeveloper.soap.ws.PaymentProcessorRequest;
import com.cleverdeveloper.soap.ws.PaymentProcessorResponse;
import com.diogonunes.jcolor.Attribute;


import java.net.MalformedURLException;
import java.net.URL;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class PaymentWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        // Coloring outputs
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(0, 0, 0);

        PaymentProcessorImplService service = new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/paymentProcessor?wsdl"));
        PaymentProcessor port = service.getPaymentProcessorImplPort();

        PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
        System.out.println(colorize("is request send ? " +response.isResult(), BOLD(), textColor, backgroundColor));
    }
}
