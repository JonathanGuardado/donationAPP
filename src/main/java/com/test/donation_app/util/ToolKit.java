package com.test.donation_app.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class ToolKit {

	public static String getLoggedUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String userName = auth.getName(); //logged username 
		return userName;
	}
	
}
