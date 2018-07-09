package com.test.donation_app.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.donation_app.dao.UserDao;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		com.test.donation_app.entities.User userInfo = userDAO.getOne(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());		
		User user = new User(userInfo.getUserName(),userInfo.getPassword(),Arrays.asList(authority));		
		UserDetails userDetails = (UserDetails)user; 
		return userDetails;
	}
}