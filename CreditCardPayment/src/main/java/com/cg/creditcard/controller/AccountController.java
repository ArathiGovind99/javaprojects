package com.cg.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.dto.AccountDto;
import com.cg.creditcard.entity.Account;
import com.cg.creditcard.service.AccountService;
@RestController
@RequestMapping("/account")
public class AccountController  {
	@Autowired
	AccountService service;
	
	@PostMapping("/addaccount")
	public ResponseEntity<String> addAccount(@RequestBody AccountDto accountDto) {
		service.addAccount(accountDto);
		return new ResponseEntity<String>("Account inserted",HttpStatus.OK);
		}
	
	@DeleteMapping("/deleteaccount")
	public ResponseEntity<String> removeAccount(@RequestParam int account_id) {
		service.removeAccount(account_id);
		return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getaccount")
	public ResponseEntity<Account> getAccount(@RequestParam int account_id) {
		Account account = service.getAccount(account_id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@PutMapping("/updateaccount")
	public ResponseEntity<String> updateAccount(@RequestBody Account account,@RequestParam int account_id) {
		service.updateAccount(account_id, account);
		return new ResponseEntity<String>("Successfully updated", HttpStatus.OK); 
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Account>> getAllAccount(){
		List<Account> accountList = service.getAllAccount();
		return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
	}
}
