package com.cg.creditcard.test;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.cg.creditcard.dao.AccountRepository;
import com.cg.creditcard.entity.Account;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.service.AccountService;

@RunWith(MockitoJUnitRunner.class)
public class TestAccount {
	@InjectMocks
	AccountService accountservice;
	
	@Mock
	AccountRepository dao;
	
	@Test
	public void addAccount() {

		Account account=new Account();
		account.setAccount_id(126);
		account.setAccount_name("abc");
		account.setBalance(45000);
		dao.save(account);
		Assert.assertNotNull(account.getAccount_id());
		Mockito.verify(dao,Mockito.times(1)).save(account);
	}
	
	@Test
	public void getAccount() {
		Customer customer=new Customer();
		customer.setUserid(12);
		customer.setFirst_name("Amrutha");
		customer.setLast_name("Arun");
		customer.setEmail("amrutha@gmail.com");
		customer.setContact_no("121911");
		Date date= Date.valueOf("1999-05-08");
		customer.setDob(date);
		customer.setPassword("a1234");
		customer.setAddress(null);
		customer.setCreditcard(null);
		customer.setPayment(null);

		List<Account>accList=new ArrayList<>();
		accList.add(new Account(121,"abc",4600.00,customer));
		Mockito.when(dao.findAll()).thenReturn(accList);
		List<Account>list=accountservice.getAllAccount();
		Assertions.assertEquals(1,list.size());
		Mockito.verify(dao,Mockito.times(1)).findAll();
	}
}
