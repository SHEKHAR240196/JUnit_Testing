package com.shekhar.service;

import java.util.List;

import com.shekhar.entity.Country;

public interface CountryService {
	
	public List<Country> getAllCountries();   
	
	public Country getCountryById(Integer id);
	
	public Country getCountryByName(String countryname);
	
	public Country addCountry(Country country);
	
	public Country updateCountry(Country country, Integer id );
	
	public void deleteCountry(Country country);

}
