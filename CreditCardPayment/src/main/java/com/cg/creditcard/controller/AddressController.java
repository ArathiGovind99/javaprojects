package com.cg.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.dto.AddressDto;
import com.cg.creditcard.entity.Address;
import com.cg.creditcard.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService service;
	
	@PostMapping("/addaddress")
	public ResponseEntity<String> addAddress(@RequestBody AddressDto addressDto)
	{
		service.addAddress(addressDto);
		return new ResponseEntity<>("Address added",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteaddress")
	public ResponseEntity<String> deleteCreditCard(@RequestParam int addressid)
	{
		service.removeAddress(addressid);
		return new ResponseEntity<String>("Address deleted..",HttpStatus.OK);
	}
	
	@PutMapping("/updateaddress")
	public ResponseEntity<String> updateAddress(@RequestBody Address address,@RequestParam int addressid)
	{
		service.updateAddress(addressid, address);
		return new ResponseEntity<String>("Successfully updated",HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Address>> getAllAddress()
	{
		List<Address> addList=service.getAllAddress();
		return new ResponseEntity<List<Address>>(addList,HttpStatus.OK);
	}
	
}
