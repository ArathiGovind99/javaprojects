package com.cg.creditcard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcard.dao.AccountRepository;
import com.cg.creditcard.dto.AccountDto;
import com.cg.creditcard.entity.Account;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class AccountService implements IAccountService {
	@Autowired
	AccountRepository dao;
	List<Account> accountList=new ArrayList<>();

	@Override
	public void addAccount(AccountDto accountDto) {
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Account account=new Account();
		account=mapper.convertValue(accountDto, Account.class);
		dao.save(account);
	}
	@Override
	public void removeAccount(int account_id) throws IDNotFoundException{
		if(dao.existsById(account_id)) {
			dao.deleteById(account_id);
	         }
		
		throw new IDNotFoundException();
	}
	@Override
	public Account getAccount(int account_id)throws IDNotFoundException {
		accountList=dao.findAll();
		for(Account acc:accountList) {
			if(acc.getAccount_id()==account_id) {
		return dao.findById(account_id).orElse(null);
             	}
		}
		throw new IDNotFoundException();
	}
	@Override
	public void updateAccount(int account_id, Account account)throws IDNotFoundException {
		if(dao.existsById(account_id)) {
			Account accountupdate=dao.findById(account_id).get();
			accountupdate.setAccount_id(account.getAccount_id());
			accountupdate.setAccount_name(account.getAccount_name());
			accountupdate.setBalance(account.getBalance());
			dao.save(accountupdate);
		}
		throw new IDNotFoundException();
	}
	@Override
	public List<Account> getAllAccount() throws ListIsEmptyException{
		List<Account> accountList =dao.findAll();
		if (accountList==null) {
			throw new ListIsEmptyException();
		}
		return accountList;
	}
}
