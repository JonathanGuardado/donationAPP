package com.test.donation_app.service;


import java.util.List;

import com.test.donation_app.entities.Donation;

public interface DonationService extends GenericService<Donation>{

	Donation findDonationsByMonthAndUserName(String month,String userName);
	
	List<Donation> findDonationsByCreditCardUserUserName(String userName);
}
