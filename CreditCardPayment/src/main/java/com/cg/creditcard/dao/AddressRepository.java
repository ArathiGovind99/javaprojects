package com.cg.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.creditcard.entity.Address;
@Repository
public interface AddressRepository  extends JpaRepository<Address,Integer>{


}
