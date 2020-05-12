package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	CountryRepository cr;
	
	@Transactional
	public List<Country> getAllCountries() {
		List<Country> countries=cr.findAll();
		return countries;
	}
	@Transactional
	public Country insertCountry(Country c) {
		return cr.save(c);
	}
	@Transactional
	public Country getCountry(String id) {
		Optional<Country> findById = cr.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
		
	}
	@Transactional
	public Country updateCountry(Country country) {
		
		
		return cr.save(country);
		
	}
	@Transactional
	public void deleteCountry(String id) {
		
		cr.deleteById(id);
		
		
	}
	@Transactional
	public List<Country> findByM(String s) {
		
		return cr.findByNameMatch(Sort.by("name").ascending(),s);
	}
	@Transactional
	public List<Country> findByAlpha(String s) {
		
		return cr.findStartsWith("a");
	}
	

}
