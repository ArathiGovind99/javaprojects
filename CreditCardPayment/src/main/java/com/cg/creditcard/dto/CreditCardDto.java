package com.cg.creditcard.dto;

public class CreditCardDto {
	private int card_number;
	private String card_name;
	private int expiry_month;
	private int expiry_year;
	private double amount_limit;
	private CustomerDto customer;
	public int getCard_number() {
		return card_number;
	}
	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public int getExpiry_month() {
		return expiry_month;
	}
	public void setExpiry_month(int expiry_month) {
		this.expiry_month = expiry_month;
	}
	public int getExpiry_year() {
		return expiry_year;
	}
	public void setExpiry_year(int expiry_year) {
		this.expiry_year = expiry_year;
	}
	public double getAmount_limit() {
		return amount_limit;
	}
	public void setAmount_limit(double amount_limit) {
		this.amount_limit = amount_limit;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
}
