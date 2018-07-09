package com.test.donation_app.dao;

import java.util.List;

import com.test.donation_app.entities.Donation;

public interface DonationDao extends Dao<Donation>{
	 
	Donation findDonationsByMonthAndCreditCardUserUserName(String month,String userName);
	
	List<Donation> findDonationsByCreditCardUserUserName(String userName);
}
