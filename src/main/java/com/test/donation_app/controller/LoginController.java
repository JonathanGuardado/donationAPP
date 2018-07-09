package com.test.donation_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
		
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping({"/",""})
	public String index() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/user/error")
	public String error() {
		return "error";
	}
	
	
}
