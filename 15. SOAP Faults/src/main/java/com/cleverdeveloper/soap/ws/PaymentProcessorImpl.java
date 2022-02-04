package com.cleverdeveloper.soap.ws;


import com.cleverdeveloper.soap.ws.dto.PaymentProcessorRequest;
import com.cleverdeveloper.soap.ws.dto.PaymentProcessorResponse;
import com.cleverdeveloper.soap.ws.exceptions.ServiceException;

public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) throws ServiceException {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		if (paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null ||
				paymentProcessorRequest.getCreditCardInfo().getCardNumber().length() == 0) {
			throw new ServiceException("Invalid Card Number");
		}
		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
