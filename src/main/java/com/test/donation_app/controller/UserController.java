package com.test.donation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.donation_app.entities.User;
import com.test.donation_app.service.CreditCardService;
import com.test.donation_app.service.DonationService;
import com.test.donation_app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	

	@Autowired
	CreditCardService creditCardService;
	
	@Autowired
	DonationService donationService; 
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("newUser") User user,ModelMap model) {
		User u =userService.save(user);
		if(u != null) {
			return "redirect:/user/login";	
		}else {			
			model.addAttribute("error", "user name already exists, please select another");
			return "sign-up";
		}		
		
	}
	
	@GetMapping("/secure/donations-details")
	public String getAllDonations(ModelMap model) {		 
	  //   donationService.findDonationsByUserName(ToolKit.getLoggedUserName());
		//model.addAttribute("donations",);
		
		return "donations";
		
	}
	
	@GetMapping("/signup")
	public String signUp(ModelMap model) {
		model.addAttribute("newUser", new User());
		return "sign-up";
	}
	
	
	
}
