package com.test.donation_app.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.donation_app.dao.UserDao;
import com.test.donation_app.entities.User;
import javassist.NotFoundException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;

	@Override
	public User save(User o) {
		// TODO Auto-generated method stub
		Optional<User> u =userDao.findById(o.getUserName());
		if(!u.isPresent()) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			o.setPassword(bCryptPasswordEncoder.encode(o.getPassword()));
			o.setRole("ROLE_USER");
			return userDao.save(o);			
		}else {
			return null;
		}		
	}

	@Override
	public void delete(User o) {
		// TODO Auto-generated method stub
		userDao.delete(o);
		
	}

	@Override
	public User update(User o) {
		// TODO Auto-generated method stub
		return userDao.saveAndFlush(o);
	}

	@Override
	public User findByUserName(String id) throws NotFoundException {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}





}
