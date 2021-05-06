package com.cg.creditcard.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.creditcard.dao.PaymentRepository;
import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.service.PaymentService;

@RunWith(MockitoJUnitRunner.class)
public class TestPayment {
	@InjectMocks
	PaymentService service;
	@Mock
	PaymentRepository dao;
	@Test
	public void addPayment() {
		Payment payment=new Payment();
		payment.setPaymentId(121);
		payment.setStatus("processing");
		payment.setAmount(200.00);
		dao.save(payment);
		Assert.assertNotNull(payment.getPaymentId());
		Mockito.verify(dao,Mockito.times(1)).save(payment);
	}

}
