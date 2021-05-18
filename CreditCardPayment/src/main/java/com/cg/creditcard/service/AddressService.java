package com.cg.creditcard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcard.dao.AddressRepository;
import com.cg.creditcard.dto.AddressDto;
import com.cg.creditcard.entity.Address;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class AddressService implements IAddressService {
	@Autowired
	AddressRepository dao;
	List<Address>AddressList=new ArrayList<>();
	@Override
	public void addAddress(AddressDto addressDto) {
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Address address=new Address();
		address=mapper.convertValue(addressDto, Address.class);
		dao.save(address);
		
	}
	@Override
	public String removeAddress(int addressid)  throws IDNotFoundException{
		
			
			 List<Address> addList=dao.findAll();
			 for(Address address:addList) {
				 if(address.getAddressid()==addressid) {
					 dao.deleteById(addressid);
					 return "address deleted";
			}
			}
			 
		throw new IDNotFoundException();
	}
	@Override
	public String updateAddress(int addressid, Address address) throws IDNotFoundException {
		if(dao.existsById(addressid)) {
			Address addressupdate=dao.findById(addressid).get();
			addressupdate.setHouse_no(address.getHouse_no());
			addressupdate.setStreet(address.getStreet());
			addressupdate.setArea(address.getArea());
			addressupdate.setCity(address.getCity());
			addressupdate.setState_name(address.getState_name());
			addressupdate.setPincode(address.getPincode());
			dao.save(addressupdate);
			return " address updated";
		}
		throw new IDNotFoundException();
		
	}
	@Override
	public List<Address> getAllAddress() throws ListIsEmptyException{
		List<Address>addlist=dao.findAll();
		if(addlist==null) {
			throw new ListIsEmptyException();
		}
		return addlist;
	}

}
