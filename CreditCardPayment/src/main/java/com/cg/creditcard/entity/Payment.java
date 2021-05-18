
package com.cg.creditcard.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

//Entity with table name="Payment"
@Entity
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@Column
	private String status;
	@Column
	private double amount;
	@Column
	private LocalDateTime transaction_date;

	//Many to one mapping with Customer table
	@ManyToOne
	@JoinColumn(name="userid")
	 @JsonBackReference
	    private Customer customer;
	//One to one mapping with Statement table
//		@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "due_date")
//	   private Statement statement;
	
	//Constructor
	public Payment() {
	}

	//Parameterized Constructor
	
	public Payment(int paymentId, String status, double amount, LocalDateTime transaction_date, Customer customer) {
		super();
		this.paymentId = paymentId;
		this.status = status;
		this.amount = amount;
		this.transaction_date = transaction_date;
		this.customer = customer;
	}
	//Required getters and setters

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDateTime transaction_date) {
		this.transaction_date = transaction_date;
	}
	
//
//	public Statement getStatement() {
//		return statement;
//	}
//
//	public void setStatement(Statement statement) {
//		this.statement = statement;
//	}
}