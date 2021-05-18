package com.cg.creditcard.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcard.dao.StatementRepository;
import com.cg.creditcard.entity.Statement;
import com.cg.creditcard.utils.ListIsEmptyException;
@Service
public class StatementService implements IStatementService  {
	@Autowired
	StatementRepository dao;
	
	List<Statement>statementList=new ArrayList<>();

	@Override
	public Statement getStatement(int statement_id)  {
		return dao.findById(statement_id).orElse(null);
	}
	

	@Override
	public List<Statement> getAllStatement() throws ListIsEmptyException {
		List<Statement>statementList=dao.findAll();
		if(statementList==null) {
			throw new  ListIsEmptyException();
		}
		return statementList;
	}


	@Override
	public void addStatement(Statement statement) {
		dao.save(statement);
		
	}
}
