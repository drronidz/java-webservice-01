package com.cleverdeveloper.soap.ws;


import com.cleverdeveloper.soap.ws.dto.PaymentProcessorRequest;
import com.cleverdeveloper.soap.ws.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest);
}
