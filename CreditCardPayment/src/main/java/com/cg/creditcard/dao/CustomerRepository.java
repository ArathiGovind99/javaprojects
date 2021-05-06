package com.cg.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcard.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value = "from Customer customer where customer.email=?1 and customer.password=?2")
	public Customer validate(String email, String password);
}
