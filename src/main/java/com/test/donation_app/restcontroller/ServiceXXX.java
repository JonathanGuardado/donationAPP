package com.test.donation_app.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.donation_app.entities.Donation;
import com.test.donation_app.pojo.CustomDonation;
import com.test.donation_app.service.DonationService;

@RestController
public class ServiceXXX {
	
	@Autowired
	DonationService donationService;
	
@GetMapping("/servicexxx")
public List<CustomDonation> servicexxx() {
	List<Donation> donations=donationService.getAll();
	List<CustomDonation> customDonations=new ArrayList<>();	
	for (Donation donation : donations) {
		CustomDonation c=new CustomDonation();
		c.setName(donation.getCreditCard().getUser().getName());
		c.setSurName(donation.getCreditCard().getUser().getSurnames());
		c.setEmail(donation.getCreditCard().getUser().getEmail());
		c.setDocumentId(donation.getCreditCard().getUser().getIdDocument());
		c.setCountry(donation.getInstitution().getDepartment().getCountry().getCountryName());
		c.setDepartment(donation.getInstitution().getDepartment().getDepartmentName());
		c.setInstitution(donation.getInstitution().getInstitutionName());
		c.setDonationAmount(donation.getDonationAmount());
		c.setDonationDate(donation.getDate());
		customDonations.add(c);
	}
	return customDonations;
}

}
