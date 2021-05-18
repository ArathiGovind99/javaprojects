package com.cg.creditcard.service;

import java.util.List;
import com.cg.creditcard.dto.PaymentDto;
import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.NoTransactionFoundException;
public interface IPaymentService {
	public void addPayment(PaymentDto paymentDto);
	public Payment payment(int paymentId) throws IDNotFoundException;
	public List<Payment> getAllDetails() throws NoTransactionFoundException; 

}
