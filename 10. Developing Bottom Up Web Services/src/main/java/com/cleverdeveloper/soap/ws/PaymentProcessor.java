package com.cleverdeveloper.soap.ws;


import com.cleverdeveloper.soap.ws.dto.PaymentProcessorRequest;
import com.cleverdeveloper.soap.ws.dto.PaymentProcessorResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="PaymentProcessor")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name="response")
	PaymentProcessorResponse processPayment(
			@WebParam(name = "PaymentProcessorRequest")
					PaymentProcessorRequest paymentProcessorRequest);
}
