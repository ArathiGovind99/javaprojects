package com.cg.creditcard.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CreditCardPaymentExceptionHandler {
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException cnfx){
		return new ResponseEntity<Object>("Customer not found...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<Object> exception(AccountNotFoundException cnfx){
		return new ResponseEntity<Object>("Account not found...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CardNumberNotFoundException.class)
	public ResponseEntity<Object> exception(CardNumberNotFoundException cnfx){
		return new ResponseEntity<Object>("Card number not found...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ListIsEmptyException.class)
	public ResponseEntity<Object> exception(ListIsEmptyException cnfx){
		return new ResponseEntity<Object>("List is empty...",HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = IDNotFoundException.class)
	public ResponseEntity<Object> exception(IDNotFoundException idnfe){
		return new ResponseEntity<Object>("ID not found...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = NoTransactionFoundException.class)
	public ResponseEntity<Object> exception(NoTransactionFoundException cnfx){
		return new ResponseEntity<Object>("No transactions found.....",HttpStatus.NOT_FOUND);
	}
	

}
