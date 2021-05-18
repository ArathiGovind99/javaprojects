package com.cg.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.dto.AccountDto;
import com.cg.creditcard.entity.Account;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.service.AccountService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/account")
public class AccountController  {
	@Autowired
	AccountService service;
	
	@PostMapping
	public ResponseEntity<String> addAccount(@RequestBody AccountDto accountDto) {
		service.addAccount(accountDto);
	Customer customer=new Customer();
	customer.getUserid();
	System.out.println(customer);
		return new ResponseEntity<String>("Account inserted",HttpStatus.OK);
		}
	
	@DeleteMapping("/deleteAccount/{account_id}")
	public ResponseEntity<String> removeAccount(@PathVariable("account_id") int account_id) {
		service.removeAccount(account_id);
		return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getaccount/{account_id}")
	public ResponseEntity<Account> getAccount(@PathVariable ("account_id ")int account_id) {
		Account account = service.getAccount(account_id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@PutMapping("/updateAccount")
	public ResponseEntity<String> updateAccount(@RequestParam int account_id,@RequestBody Account account) {
		service.updateAccount(account_id, account);
		return new ResponseEntity<String>("Successfully updated", HttpStatus.OK); 
	}
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccount(){
		List<Account> accountList = service.getAllAccount();
		return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
	}
}
