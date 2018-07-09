package com.test.donation_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface Dao<T> extends JpaRepository<T, Integer>{

    
	
}