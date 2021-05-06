package com.cg.creditcard.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//Entity with table name ="Account"
@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int account_id;
	@Column
	private String account_name;
	@Column
	private double balance;
	
	//Many to one mapping to Customer table
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="userid")
 @JsonBackReference
    private Customer customer;
	
//required getters and setters
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
