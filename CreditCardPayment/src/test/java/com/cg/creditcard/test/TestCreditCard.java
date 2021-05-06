package com.cg.creditcard.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.creditcard.dao.CreditCardRepository;
import com.cg.creditcard.entity.CreditCard;
import com.cg.creditcard.service.CreditCardService;

@RunWith(MockitoJUnitRunner.class)
public class TestCreditCard {
	@InjectMocks
	CreditCardService service;
	@Mock
	CreditCardRepository dao;
	@Test
	public void addCreditCard() {
		CreditCard creditcard = new CreditCard();
		creditcard.setCard_number(2345);
		creditcard.setCard_name("mastercard");
		creditcard.setExpiry_month(10);
		creditcard.setExpiry_year(2024);
		creditcard.setAmount_limit(450000);
		dao.save(creditcard);
		Assert.assertNotNull(creditcard.getCard_number());
		Mockito.verify(dao,Mockito.times(1)).save(creditcard);
		
	}

}
