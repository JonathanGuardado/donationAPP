package com.test.donation_app.service;


import java.util.List;

import com.test.donation_app.entities.CreditCard;

public interface CreditCardService extends GenericService<CreditCard>{
	
	List<CreditCard> findCreditCardByUserName(String userName);
	
	CreditCard validateCreditCard(String cardNumber,String securityNumber);
		
}
