package com.shekhar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shekhar.entity.Country;
import com.shekhar.repository.CountryRepo;

public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepo countryRepo;

	@Override
	public List<Country> getAllCountries() {
		List<Country> allCountry = countryRepo.findAll();
		return allCountry;
	}

	@Override
	public Country getCountryById(Integer id) {
		List<Country> all = this.countryRepo.findAll();
		Country country=null;
		
		for(Country con:all) {
			if(con.getId() == id) 
				country=con;
			}

		return country;
	}

	@Override
	public Country getCountryByName(String countryname) {
		List<Country> all = this.countryRepo.findAll();
		Country country=null;
		
		for(Country con:all) {
			if(con.getCountryName().equalsIgnoreCase(countryname))
				country=con;
		}
		return country;
	}

	@Override
	public Country addCountry(Country country) {
		Country save = countryRepo.save(country);
		
		return save;
	}

	@Override
	public Country updateCountry(Country country, Integer id) {
		country.setId(id);
		Country save = countryRepo.save(country);
		return save;
	}

	@Override
	public void deleteCountry(Country country) {
		countryRepo.delete(country);

	}

}
