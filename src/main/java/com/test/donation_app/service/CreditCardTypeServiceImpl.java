package com.test.donation_app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.donation_app.dao.CreditCardTypeDao;
import com.test.donation_app.dao.Dao;
import com.test.donation_app.entities.CreditCardType;

@Service
public class CreditCardTypeServiceImpl extends BaseService<CreditCardType> implements CreditCardTypeService{

	@Autowired
	CreditCardTypeDao creditCardTypeDao;
	
	@Override
	public Dao<CreditCardType> getDao() {
		// TODO Auto-generated method stub
		return creditCardTypeDao;
	}

}
