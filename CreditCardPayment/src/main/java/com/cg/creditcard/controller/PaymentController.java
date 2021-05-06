package com.cg.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.dto.PaymentDto;
import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService service;
	
	@PostMapping("/addpayment")
	public ResponseEntity<String> addCreditCard(@RequestBody PaymentDto paymentDto)
	{
		service.addPayment(paymentDto);
		return new ResponseEntity<>("New payment  added",HttpStatus.OK);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Payment>>getAllDetailst()
	{
		List<Payment>transList=service.getAllDetails();
		return new ResponseEntity<List<Payment>>(transList,HttpStatus.OK);
	}
	
	@GetMapping("/getpayment")
	public ResponseEntity<Payment>getPaymentDetails(@RequestParam int paymentId)
	{
		Payment transaction=service.getPaymentDetails(paymentId);
		return new ResponseEntity<Payment>(transaction,HttpStatus.OK);
	}
}
