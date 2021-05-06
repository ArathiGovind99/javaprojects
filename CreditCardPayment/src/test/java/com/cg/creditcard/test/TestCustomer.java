package com.cg.creditcard.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.creditcard.dao.CustomerRepository;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomer {
	@InjectMocks
	CustomerService service;
	@Mock
	CustomerRepository dao;
	@Test
	public void addCustomer() {
		Customer customer=new Customer();
		customer.setFirst_name("Arathi");
		customer.setLast_name("govind");
		customer.setEmail("abc@gmail.com");
		customer.setContact_no("234568");
		customer.setPassword("abcdef");
		dao.save(customer);
		Assert.assertNotNull(customer.getPassword());
		Mockito.verify(dao,Mockito.times(1)).save(customer);
		
	}

}
