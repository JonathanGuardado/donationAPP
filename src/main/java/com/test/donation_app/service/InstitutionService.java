package com.test.donation_app.service;


import java.util.List;

import com.test.donation_app.entities.Institution;

public interface InstitutionService extends GenericService<Institution>{
	
	List<Institution> findInstitutionsByCountryId(int id);
}
