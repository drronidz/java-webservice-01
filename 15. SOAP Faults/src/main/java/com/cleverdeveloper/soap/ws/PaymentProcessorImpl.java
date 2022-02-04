package com.cleverdeveloper.soap.ws;


import com.cleverdeveloper.soap.ws.dto.PaymentProcessorRequest;
import com.cleverdeveloper.soap.ws.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		if (paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null ||
				paymentProcessorRequest.getCreditCardInfo().getCardNumber().length() == 0) {
			throw new RuntimeException("Invalid Card Number");
		}
		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
