package com.shekhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shekhar.entity.Country;
import com.shekhar.exception.UserNotFoundException;
import com.shekhar.service.CountryServiceImpl;

@RestController
public class CountryController {

	@Autowired
	private CountryServiceImpl service;

	@PostMapping("/saveUser")
	public ResponseEntity<Country> addcountry(@RequestBody Country country) {

		if (country == null) {
			throw new UserNotFoundException("user not found");
		} else {
			Country save = service.addCountry(country);
			return new ResponseEntity<Country>(save, HttpStatus.CREATED);
		}

	}

//	@GetMapping("/getAllCountries/pageNumber/{pageNumber}/pageSize/{pageSize}")
//	public ResponseEntity<List<Country>> getAllCountries(
//			@RequestParam(value = "pageNumber", defaultValue = "1", required = true) Integer pageNumber,
//			@RequestParam(value = "pageSize", defaultValue = "1", required = true) Integer pageSize) {
//		if (pageNumber == null  && pageSize==null) {
//			throw new UserNotFoudException("User Not Found");
//
//		}
//
//		else {
//
//			List<Country> allCountries = this.service.getAllCountries(pageNumber, pageSize);
//
//			return new ResponseEntity<List<Country>>(allCountries, HttpStatus.FOUND);
//		}
//
//	}
//	
//	
	@GetMapping("/getAllCountries")
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> allcountries = this.service.getAllCountries();

		return new ResponseEntity<List<Country>>(allcountries, HttpStatus.FOUND);

	}

	@GetMapping("/getCountryById/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") Integer id) {

		if (id == null) {
			throw new UserNotFoundException("user not found");
		} else {
			Country countryById = this.service.getCountryById(id);
			return new ResponseEntity<Country>(countryById, HttpStatus.FOUND);
		}

	}

	@GetMapping("/getCountryByName")
	public ResponseEntity<Country> getCountryByName(@RequestParam String countryname) {

		if (countryname == null) {
			throw new UserNotFoundException("user not found");
		} else {
			Country countryByName = this.service.getCountryByName(countryname);
			return new ResponseEntity<Country>(countryByName, HttpStatus.FOUND);
		}

	}

//	public Country addCountry(Country country) {
//		Country save = countryRepo.save(country);
//		return save;
//	}
//
//	public Country updateCountry(Country country, Integer id) {
//
//		country.setId(id);
//		Country save = countryRepo.save(country);
//		return save;
//	}
//
//	public void deleteCountry(Country country) {
//
//		countryRepo.delete(country);
//	}
}
