package com.cg.creditcard.dto;

import java.sql.Date;
import java.util.List;
public class CustomerDto {
	private int userid;
	private String first_name;
	private String last_name;
	private String email;
	private String contact_no;
	private Date dob;
	private String password;
	private String message;
	private String role;
	// private int statement;
	private List<AccountDto> account;
	private List<AddressDto>address;
	private List<CreditCardDto>creditcard;
	private List<PaymentDto>payment;
	
	//Requires getters and setters
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
	public List<AccountDto> getAccount() {
		return account;
	}
	public void setAccount(List<AccountDto> account) {
		this.account = account;
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
	public List<CreditCardDto> getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(List<CreditCardDto> creditcard) {
		this.creditcard = creditcard;
	}
	public List<PaymentDto> getPayment() {
		return payment;
	}
	public void setPayment(List<PaymentDto> payment) {
		this.payment = payment;
	}
	public List<AddressDto> getAddress() {
		return address;
	}
	public void setAddress(List<AddressDto> address) {
		this.address = address;
	}
	
}

