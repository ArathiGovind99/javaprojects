package com.cg.creditcard.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.dto.AccountDto;
import com.cg.creditcard.dto.CreditCardDto;
import com.cg.creditcard.dto.CustomerDto;
import com.cg.creditcard.dto.PaymentDto;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.service.AccountService;
import com.cg.creditcard.service.CreditCardService;
import com.cg.creditcard.service.CustomerService;
import com.cg.creditcard.service.PaymentService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService service;
	@Autowired
	AccountService accService;
	@Autowired
	CreditCardService ccService;
	@Autowired
	PaymentService payService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerDto) {
		Random rand=new Random();
	   int  random=rand.nextInt(1000);
		 customerDto.setUserid(random);
		System.out.println(	customerDto);
		service.addCustomer(customerDto);
	  AccountDto acc=new AccountDto();
	  acc.setCustomer(customerDto);
	  accService.addAccount(acc);
	  CreditCardDto cc=new CreditCardDto();
	  cc.setCustomer(customerDto);
	  ccService.addCreditCard(cc);
	  PaymentDto pay=new PaymentDto();
	  pay.setCustomer(customerDto);
	  payService.addPayment(pay);
	  
		return new ResponseEntity<String>("Customer inserted",HttpStatus.OK);
		
		}
	
	@DeleteMapping("/deletecustomer")
	public ResponseEntity<String> removeCustomer(@RequestParam int userid) {
		service.removeCustomer(userid);
		return new ResponseEntity<String>("Customer Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getcustomer")
	public ResponseEntity<Customer> getCustomer(@RequestParam int userid) {
		Customer customer = service.getCustomer(userid);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer,@RequestParam int userid) {
		service.updateCustomer(userid, customer);
		return new ResponseEntity<String>("Successfully updated", HttpStatus.OK); 
	}
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllCustomer(){
		List<CustomerDto> customerList = service.getAllCustomer();
		return new ResponseEntity<List<CustomerDto>>(customerList, HttpStatus.OK);
	}
	@PostMapping("/validate")
	public ResponseEntity<Customer> validate(@RequestBody Customer customer){
		Customer log=service.validate(customer.getEmail(),customer.getPassword());
		return new ResponseEntity<Customer>(log,HttpStatus.OK);
	}

}
