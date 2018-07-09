package com.test.donation_app.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.test.donation_app.entities.Institution;

public interface InstitutionDao extends Dao<Institution> {
	
	@Query("SELECT DISTINCT i.idInstitution,i.institutionName FROM Institution i JOIN i.department d JOIN d.country c where c.idCountry=?1")
	List<Institution> findInstitutionsByCountry(int id);
}
