package com.test.donation_app.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.donation_app.entities.Donation;
import com.test.donation_app.service.CountryService;
import com.test.donation_app.service.CreditCardService;
import com.test.donation_app.service.CreditCardTypeService;
import com.test.donation_app.service.DonationService;
import com.test.donation_app.util.ToolKit;

@Controller
@RequestMapping("/donation")
public class DonationController {
	
	@Autowired
	DonationService donationService; 
	
	@Autowired
	CountryService countryService; 
	
	@Autowired
	CreditCardService creditCardService; 
	
	@Autowired
	CreditCardTypeService creditCardTypeService;
	
	@PostMapping("/save")
	public String save(@ModelAttribute("donation") Donation donation, Model model) {
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		String m=String.valueOf(calendar.get(Calendar.MONTH)+1)+"-"+String.valueOf(calendar.get(Calendar.YEAR));
		donation.setDate(date);
		donation.setMonth(m);
		Donation d=donationService.findDonationsByMonthAndUserName(m, ToolKit.getLoggedUserName());						
		if(d==null) {
			donationService.save(donation);
			model.addAttribute("message", "Your donation has been made successfully, Thank you!");
		}else {
			model.addAttribute("error", "Donation already made, to "+donation.getInstitution().getDepartment().getCountry().getCountryName()+" this month");			
		}		
		model.addAttribute("newDonation",new Donation());
		model.addAttribute("countries",countryService.getAll());
		model.addAttribute("creditCardTypes",creditCardTypeService.getAll());
		model.addAttribute("creditCards",creditCardService.findCreditCardByUserName(ToolKit.getLoggedUserName()));
		return "donation/new";
		
	}
	
	@GetMapping("/new")
	public String save(Model model) {
		Donation d=new Donation();
		model.addAttribute("newDonation",d);
		model.addAttribute("countries",countryService.getAll());
		model.addAttribute("creditCardTypes",creditCardTypeService.getAll());
		model.addAttribute("creditCards",creditCardService.findCreditCardByUserName(ToolKit.getLoggedUserName()));
		return "donation/new";
		
	}
	
	@GetMapping("/user-donations")
	public String findAll(Model model) {		
		model.addAttribute("userDonations",donationService.findDonationsByCreditCardUserUserName(ToolKit.getLoggedUserName()));
		
		return "donation/donations";
		
	}
}
