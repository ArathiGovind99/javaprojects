package com.cg.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcard.entity.Statement;
@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer>{
	@Query(value = " from Statement statement where customer.userid=?1")
	public Statement getStatementbyId(int statement_id);
}
