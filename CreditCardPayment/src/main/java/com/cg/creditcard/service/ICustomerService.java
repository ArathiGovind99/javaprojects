package com.cg.creditcard.service;

import java.util.List;
import com.cg.creditcard.dto.CustomerDto;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
public interface ICustomerService {

public void addCustomer(Customer customer);
	public void removeCustomer(int userid)throws IDNotFoundException;
	public Customer getCustomer(int userid)throws IDNotFoundException;
	public void updateCustomer(int userid, Customer customer)throws IDNotFoundException;
	public List<CustomerDto> getAllCustomer() throws ListIsEmptyException;
	
}
