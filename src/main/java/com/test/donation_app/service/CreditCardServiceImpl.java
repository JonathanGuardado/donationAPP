package com.test.donation_app.service;



import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.donation_app.dao.CreditCardDao;
import com.test.donation_app.dao.Dao;
import com.test.donation_app.entities.CreditCard;

@Service
public class CreditCardServiceImpl extends BaseService<CreditCard> implements CreditCardService{

	@Autowired
	CreditCardDao creditCardDao;
	
	
	@Override
	public Dao<CreditCard> getDao() {
		// TODO Auto-generated method stub
		return creditCardDao;
	}

	@Override
	public List<CreditCard> findCreditCardByUserName(String userName) {
		// TODO Auto-generated method stub
		return creditCardDao.findCreditCardByUserUserName(userName);
	}


	@Override
	public CreditCard save(CreditCard c) {
		c.setSecurityCode(Base64.getEncoder().encodeToString(c.getSecurityCode().getBytes()));		
		return creditCardDao.save(c);
	}

	@Override
	public CreditCard validateCreditCard(String cardNumber, String securityCode) {
		// TODO Auto-generated method stub
		String encodeSecurityCode=Base64.getEncoder().encodeToString(securityCode.getBytes());
		return creditCardDao.findCreditCardByCardNumberAndSecurityCode(cardNumber, encodeSecurityCode);
	}







}
