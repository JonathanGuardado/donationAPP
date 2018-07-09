package com.test.donation_app.service;


import com.test.donation_app.entities.User;

import javassist.NotFoundException;

public interface UserService {
	
	public User save(User o);
	
	public void delete(User o);
	
	public User update(User o);	
	
	public User findByUserName(String id) throws NotFoundException;
	
}
