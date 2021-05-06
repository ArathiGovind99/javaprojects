package com.cg.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.creditcard.entity.CreditCard;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Integer>{
	@Query(value = " from CreditCard creditcard where creditcard.card_number=?1")
	public CreditCard getCardNumberById(int card_number);
}
