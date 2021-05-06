
package com.cg.creditcard.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.creditcard.dao.StatementRepository;
import com.cg.creditcard.entity.Statement;
import com.cg.creditcard.service.StatementService;

@RunWith(MockitoJUnitRunner.class)
public class TestStatement {
	@InjectMocks
	StatementService service;
	
	@Mock
	StatementRepository dao;
	
	/*@Test
	public void testGetAllStatement() {
		List<Statement> statements=new ArrayList<Statement>();
		
		statements.add(new Statement(1, 5000,'21-09-2021','21-12-2021',1));
		Mockito.when(dao.findAll()).thenReturn(statements);
		List<Statement> list = service.getAllStatement();
		Assertions.assertEquals(1, list.size());
		Mockito.verify(dao,Mockito.times(1)).findAll();
	}*/
	
	@Test
	public void testgetStatementById() {
		Statement statement=new Statement();
		service.getStatement(1);
		Assertions.assertNotNull(statement.getStatement_id());
		Mockito.verify(dao, Mockito.times(1)).getStatementbyId(1);
	}
}
