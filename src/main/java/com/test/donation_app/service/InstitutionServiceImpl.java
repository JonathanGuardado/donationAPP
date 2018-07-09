package com.test.donation_app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.donation_app.dao.Dao;
import com.test.donation_app.dao.InstitutionDao;
import com.test.donation_app.entities.Institution;

@Service
public class InstitutionServiceImpl extends BaseService<Institution> implements InstitutionService{

	@Autowired
	InstitutionDao institutionDao;
	
	@Override
	public Dao<Institution> getDao() {
		// TODO Auto-generated method stub
		return institutionDao;
	}

	@Override
	public List<Institution> findInstitutionsByCountryId(int id) {
		// TODO Auto-generated method stub
		return institutionDao.findInstitutionsByCountry(id);
	}







}
