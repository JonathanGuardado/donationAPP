package com.test.donation_app.dao;

import java.util.List;

import com.test.donation_app.entities.CreditCard;

public interface CreditCardDao extends Dao<CreditCard>{
	
	List<CreditCard> findCreditCardByUserUserName(String userName);
	
	CreditCard findCreditCardByCardNumberAndSecurityCode(String cardNumber,String securityCode);
}
