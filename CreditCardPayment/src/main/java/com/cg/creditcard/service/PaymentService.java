package com.cg.creditcard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcard.dao.PaymentRepository;
import com.cg.creditcard.dto.PaymentDto;
import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.NoTransactionFoundException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService implements IPaymentService {
	@Autowired
	PaymentRepository dao;
	List<Payment>paymentList=new ArrayList<>();
	@Override
	public Payment getPaymentDetails(int paymentId) throws IDNotFoundException {
		paymentList=dao.findAll();
		for(Payment pt:paymentList) {
		if(pt.getPaymentId()==paymentId) {
			dao.findById(paymentId);
		return getPaymentDetails(paymentId);
		}
		}
		throw new IDNotFoundException ();
	}
	
	@Override
	public List<Payment> getAllDetails() throws NoTransactionFoundException {
		if(paymentList==null) {
			throw new NoTransactionFoundException();
		}
		return dao.findAll();
	}

	@Override
	public void addPayment(PaymentDto paymentDto) {
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Payment payment=new Payment();
		payment=mapper.convertValue(paymentDto, Payment.class);
		dao.save(payment);
	}

}
