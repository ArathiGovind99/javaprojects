package com.cg.creditcard.service;
import java.util.List;
import com.cg.creditcard.dto.CreditCardDto;
import com.cg.creditcard.entity.CreditCard;
import com.cg.creditcard.utils.CardNumberNotFoundException;
import com.cg.creditcard.utils.ListIsEmptyException;
public interface ICreditCardService {
	public void addCreditCard(CreditCardDto creditcardDto);
	public void removeCreditCard(long card_number)throws CardNumberNotFoundException;
	public void updateCreditCard(long card_number,CreditCard creditcard)throws CardNumberNotFoundException;
	public CreditCard getCreditCardById(long card_number)throws CardNumberNotFoundException;
	public List<CreditCard> getAllCreditCard() throws ListIsEmptyException;
}
