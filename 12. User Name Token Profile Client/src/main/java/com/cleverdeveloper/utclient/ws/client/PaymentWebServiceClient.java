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
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class PaymentWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        // Coloring outputs
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(0, 0, 0);

        PaymentProcessorImplService service = new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/paymentProcessor?wsdl"));
        PaymentProcessor port = service.getPaymentProcessorImplPort();
        Client client = ClientProxy.getClient(port);
        Endpoint endpoint = client.getEndpoint();

        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.USER, "cleverdeveloper");
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallBack.class.getName());


        WSS4JOutInterceptor outInterceptor = new WSS4JOutInterceptor(props);
        endpoint.getOutInterceptors().add(outInterceptor);

        PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
        System.out.println(colorize("is request send ? " +response.isResult(), BOLD(), textColor, backgroundColor));
    }
}
