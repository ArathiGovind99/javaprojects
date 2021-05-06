package com.cg.creditcard.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.creditcard.dao.AddressRepository;
import com.cg.creditcard.entity.Address;
import com.cg.creditcard.service.AddressService;

@RunWith(MockitoJUnitRunner.class)
public class TestAddress {
	@InjectMocks
    AddressService service;
	@Mock
	AddressRepository dao;
	@Test
	public void addAddress() {
		Address address=new Address();
		address.setAddressid(1234);
		address.setHouse_no("A10");
		address.setStreet("amruth nagar");
		address.setArea("near cc");
		address.setCity("Mangalore");
		address.setState_name("Karnataka");
		address.setPincode(12312);
		dao.save(address);
		Assert.assertNotNull(address.getAddressid());
		Mockito.verify(dao,Mockito.times(1)).save(address);
	}
}
