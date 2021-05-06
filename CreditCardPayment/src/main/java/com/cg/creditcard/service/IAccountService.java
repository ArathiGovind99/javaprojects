package com.cg.creditcard.service;
import java.util.List;

import com.cg.creditcard.dto.AccountDto;
import com.cg.creditcard.entity.Account;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
public interface IAccountService {
	public void addAccount(AccountDto accountDto);
	public void removeAccount(int account_id) throws IDNotFoundException;
	public Account getAccount(int account_id) throws IDNotFoundException;
	public void updateAccount(int account_id, Account account) throws IDNotFoundException;
	public List<Account> getAllAccount() throws ListIsEmptyException;

}
