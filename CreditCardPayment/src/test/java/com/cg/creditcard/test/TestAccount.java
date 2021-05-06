package com.cg.creditcard.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.creditcard.dao.AccountRepository;
import com.cg.creditcard.entity.Account;
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
}
