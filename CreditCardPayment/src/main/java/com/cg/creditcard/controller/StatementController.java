package com.cg.creditcard.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.entity.Statement;
import com.cg.creditcard.service.StatementService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/statement")
public class StatementController {
	
	@Autowired
	StatementService service;
	
	@GetMapping("/byid/{statement_id}") 
	public ResponseEntity<Statement>getStatementbyId(@PathVariable("statement_id") int statement_id)
	{
		Statement statement=service.getStatement(statement_id);
		return new ResponseEntity<Statement>(statement,HttpStatus.OK);	
	}
	
	@GetMapping
	public ResponseEntity<List<Statement>>getAllStatement(){
		List<Statement>statementList=service.getAllStatement();
		return new ResponseEntity<List<Statement>>(statementList,HttpStatus.OK);	
	}
	@PostMapping
	public ResponseEntity<String> addStatement(@RequestBody Statement statement)
	{
		service.addStatement(statement);
		return new ResponseEntity<>("New statement  added",HttpStatus.OK);
	}
}
