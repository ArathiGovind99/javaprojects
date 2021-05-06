package com.cg.creditcard.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcard.dao.CreditCardRepository;
import com.cg.creditcard.dto.CreditCardDto;
import com.cg.creditcard.entity.CreditCard;
import com.cg.creditcard.utils.CardNumberNotFoundException;
import com.cg.creditcard.utils.IDNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class CreditCardService implements ICreditCardService {
	@Autowired
	CreditCardRepository dao;
	List<CreditCard>creditcardList=new ArrayList<>();

	@Override
	public void addCreditCard(CreditCardDto creditcardDto) {
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CreditCard creditcard=new CreditCard();
		creditcard=mapper.convertValue(creditcardDto, CreditCard.class);
		dao.save(creditcard);
	}
	
	@Override
	public void removeCreditCard(int card_number) throws CardNumberNotFoundException {
		creditcardList=dao.findAll();
		for(CreditCard cc:creditcardList) {
			if(cc.getCard_number()==card_number) {
		             dao.deleteById(card_number);
		             return;
              	}
		}
		throw new CardNumberNotFoundException();	
	}
	@Override
	public void updateCreditCard(int card_number, CreditCard creditcard) throws CardNumberNotFoundException {
		if(dao.existsById(card_number)) {
			CreditCard ccupdate=dao.findById(card_number).get();
			ccupdate.setCard_number(creditcard.getCard_number());
			ccupdate.setCard_name(creditcard.getCard_name());
			ccupdate.setExpiry_month(creditcard.getExpiry_month());
			ccupdate.setExpiry_year(creditcard.getExpiry_year());
			ccupdate.setAmount_limit(creditcard.getAmount_limit());
			dao.save(ccupdate);
		}
		throw new CardNumberNotFoundException();
	}
	
	@Override
	public CreditCard getCreditCardById(int card_number) throws CardNumberNotFoundException {
		creditcardList=dao.findAll();
		for(CreditCard cc:creditcardList) {
			if(cc.getCard_number()==card_number) {
				return dao.findById(card_number).orElse(null);
			}
			}
		throw new  IDNotFoundException();
	}
	@Override
	public List<CreditCard> getAllCreditCard() throws ListIsEmptyException {
		creditcardList=dao.findAll();
		if(creditcardList==null) {
			throw new  ListIsEmptyException ();
		}
		return creditcardList;
	}
}
