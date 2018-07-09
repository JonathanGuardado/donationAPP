package com.test.donation_app.service;

import java.util.List;

import javassist.NotFoundException;

public interface GenericService<T> {
	
	public T save(T o);
	
	public void delete(T o);
	
	public List<T> getAll();
	
	public T update(T o);	
	
	public T findById(int id) throws NotFoundException;
	
}