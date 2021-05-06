package com.cg.creditcard.entity;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//Entity with table name ="Customer"
@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String email;
	@Column
	private String contact_no;
	@Column
	private Date dob;
	@Column
	private String password;
	private String message;
	private String role;
	//Constructor
	public Customer() {
	}
	//One to many mapping with the respective tables
	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
	private List<CreditCard>creditcard;

	@OneToMany(mappedBy = "customer")
	  @JsonManagedReference
	private List<Address>address;
	
	@OneToMany(mappedBy = "customer")
	  @JsonManagedReference
	private List<Payment>payment;
	
	@OneToMany(mappedBy = "customer")
  @JsonManagedReference
	private List<Account> account;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "statement_id")
  private Statement statement;
	
	
	//Required getters and setters
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<CreditCard> getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(List<CreditCard> creditcard) {
		this.creditcard = creditcard;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
}
