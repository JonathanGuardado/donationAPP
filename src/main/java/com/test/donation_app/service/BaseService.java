package com.test.donation_app.service;

import java.util.List;

import com.test.donation_app.dao.Dao;

import javassist.NotFoundException;

public abstract class BaseService<T> implements GenericService<T>{
	
	public abstract Dao<T> getDao();
	
	
	@Override
	public T save(T o) {
		// TODO Auto-generated method stub	
		return getDao().saveAndFlush(o);
		
	}

	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		getDao().delete(o);
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return getDao().findAll();
	}

	@Override
	public T update(T o) {		
		return getDao().saveAndFlush(o);
		
	}
	
	@Override
	public T findById(int id) throws NotFoundException {		
		return  (T) getDao().findById(id).orElseThrow(() -> new NotFoundException("Resource id = "+id+" not found"));
		
	}
	
	
}
