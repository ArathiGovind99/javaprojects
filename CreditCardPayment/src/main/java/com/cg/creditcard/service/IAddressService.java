package com.cg.creditcard.service;
import java.util.List;

import com.cg.creditcard.dto.AddressDto;
import com.cg.creditcard.entity.Address;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
public interface IAddressService {
	public  void addAddress(AddressDto addressDto);
	public String removeAddress(int addressid) throws IDNotFoundException;
	public String updateAddress(int addressid,Address address) throws IDNotFoundException;
	public List<Address> getAllAddress() throws ListIsEmptyException;

}
