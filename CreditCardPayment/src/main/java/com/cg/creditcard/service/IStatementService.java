package com.cg.creditcard.service;

import java.util.List;
import com.cg.creditcard.entity.Statement;
import com.cg.creditcard.utils.ListIsEmptyException;
public interface IStatementService {
	public Statement getStatement(int userid) ;
	public List<Statement> getAllStatement() throws ListIsEmptyException ;

}
