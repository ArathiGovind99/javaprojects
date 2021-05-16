package com.cg.creditcard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcard.dao.AccountRepository;
import com.cg.creditcard.dao.AddressRepository;
import com.cg.creditcard.dao.CreditCardRepository;
import com.cg.creditcard.dao.CustomerRepository;
import com.cg.creditcard.dao.PaymentRepository;
import com.cg.creditcard.dao.StatementRepository;
import com.cg.creditcard.dto.CustomerDto;
import com.cg.creditcard.entity.Address;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class CustomerService implements ICustomerService {
	@Autowired
	CustomerRepository dao;
	@Autowired
	AccountRepository accountdao;
	@Autowired
	CreditCardRepository creditcarddao;
	@Autowired
		PaymentRepository paymentdao;
	@Autowired
	StatementRepository statementdao;
	@Autowired
	AddressRepository addressdao;

	
	List<Customer> customerList=new ArrayList<>();

	@Override
	public void removeCustomer(int userid) throws IDNotFoundException {
		customerList=dao.findAll();
		for(Customer cdt:customerList) {
			if(cdt.getUserid()==userid) {
				dao.deleteById(userid);
				return;
	        }	
	    }
		throw new  IDNotFoundException();
	}

	@Override
	public Customer getCustomer(int userid) throws IDNotFoundException{
		 customerList=dao.findAll();
		for(Customer cdt:customerList) {
			if(cdt.getUserid()==userid) {
				return dao.findById(userid).orElse(null);
			}
		}
		throw new  IDNotFoundException();
	}

	@Override
	public void updateCustomer(int userid, Customer customer) throws IDNotFoundException{
		customerList=dao.findAll();
		for(Customer cdt:customerList) {
			if(cdt.getUserid()==userid) {
		dao.save(customer);
		return;
	        }
		}
		throw new IDNotFoundException();
	}

	@Override
	public List<CustomerDto> getAllCustomer() throws ListIsEmptyException {
		List<Customer> customerList =dao.findAll();
		List<CustomerDto>customerDtoList=new ArrayList<CustomerDto>();
		for(Customer customer:customerList) {
			CustomerDto customerDto=new CustomerDto();
			ObjectMapper mapper=new ObjectMapper();
			customerDto=mapper.convertValue(customer, CustomerDto.class);
		
		customerDtoList.add(customerDto);
		}
		return customerDtoList;
	}

	public Customer validate(String email,String password) {
		Customer customer =dao.validate(email,password);
		if(customer ==null) {
			customer=new Customer();
			customer.setMessage("Invalid email");
		}
		return customer;
	
	}

	@Override
	public void addCustomer(CustomerDto customerDto) {
		Customer customer=new Customer();
		Address address=new Address();
		address.setAddressid(customerDto.getAddressid());
		address.setHouse_no(customerDto.getHouse_no());
		address.setArea(customerDto.getArea());
		address.setStreet(customerDto.getStreet());
		address.setCity(customerDto.getCity());
		address.setState_name(customerDto.getState_name());
		address.setPincode(customerDto.getPincode());
	if(addressdao.findById(address.getAddressid()).isEmpty()) {
		customer.setUserid(customerDto.getUserid());
		customer.setFirst_name(customerDto.getFirst_name());
		customer.setLast_name(customerDto.getLast_name());
		customer.setEmail(customerDto.getEmail());
		customer.setContact_no(customerDto.getContact_no());
		customer.setDob(customerDto.getDob());
		customer.setPassword(customerDto.getPassword());
		customer.setRole(customerDto.getRole());
		customer.setAddress(address);
			addressdao.save(address);
			 dao.save(customer);
			}
		else {
		customer.setMessage("invalid Address");
		dao.save(customer);
		
	}
	}
}

	

