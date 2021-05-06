package com.cg.creditcard.entity;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//Entity with table name
@Entity
@Table(name="Statement")
public class Statement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statement_id;
	@Column
	private double due_amount;
	@Column
	private Date billing_date;
	@Column
	private Date due_date;
	
//	One to one mapping with Customer table
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
  private Customer customer;

	//Required getters and setters
	
	public int getStatement_id() {
		return statement_id;
	}
	public void setStatement_id(int statement_id) {
		this.statement_id = statement_id;
	}
	public double getDue_amount() {
		return due_amount;
	}
	public void setDue_amount(double due_amount) {
		this.due_amount = due_amount;
	}
	public Date getBilling_date() {
		return billing_date;
	}
	public void setBilling_date(Date billing_date) {
		this.billing_date = billing_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
