package com.cg.creditcard.dto;

public class AddressDto {
	private int addressid;
	private String house_no;
	private String street;
	private String area;
	private String city;
	private String state_name;
	private int pincode;
	//private CustomerDto customer;
	
	public String getHouse_no() {
		return house_no;
	}
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
//	public CustomerDto getCustomer() {
//		return customer;
//	}
//	public void setCustomer(CustomerDto customer) {
//		this.customer = customer;
//	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	
}
