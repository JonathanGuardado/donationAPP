package com.test.donation_app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.donation_app.entities.Institution;
import com.test.donation_app.service.InstitutionService;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

	@Autowired
	InstitutionService institutionService;
	
	@GetMapping("/find/{country}")
	public List<Institution> getInstitutionsByCountry(@PathVariable("country") int countryId){
		return institutionService.findInstitutionsByCountryId(countryId);		
	}
	
}
