package com.test.donation_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.donation_app.entities.User;

public interface UserDao extends JpaRepository<User, String>{

}
