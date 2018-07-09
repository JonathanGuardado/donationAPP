package com.test.donation_app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.donation_app.dao.Dao;
import com.test.donation_app.dao.DonationDao;
import com.test.donation_app.entities.Donation;

@Service
public class DonationServiceImpl extends BaseService<Donation> implements DonationService{

	@Autowired
	DonationDao donationDao;
	
	@Override
	public Dao<Donation> getDao() {
		// TODO Auto-generated method stub
		return donationDao;
	}

	@Override
	public Donation findDonationsByMonthAndUserName(String month, String userName) {
		// TODO Auto-generated method stub
		return donationDao.findDonationsByMonthAndCreditCardUserUserName(month, userName);
	}

	@Override
	public List<Donation> findDonationsByCreditCardUserUserName(String userName) {
		// TODO Auto-generated method stub
		return donationDao.findDonationsByCreditCardUserUserName(userName);
	}
	

}
