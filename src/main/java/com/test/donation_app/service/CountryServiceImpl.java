package com.test.donation_app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.donation_app.dao.CountryDao;
import com.test.donation_app.dao.Dao;
import com.test.donation_app.entities.Country;

@Service
public class CountryServiceImpl extends BaseService<Country> implements CountryService{

	@Autowired
	CountryDao countryDao;
	
	@Override
	public Dao<Country> getDao() {
		// TODO Auto-generated method stub
		return countryDao;
	}







}
