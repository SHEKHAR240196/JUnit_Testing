package com.shekhar.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shekhar.entity.Country;
import com.shekhar.exception.UserNotFoundException;
import com.shekhar.service.CountryServiceImpl;

@SpringBootTest(classes = CountryControllerTest.class)
class CountryControllerTest {
	
	@Mock
	private CountryServiceImpl service;
	
	@InjectMocks
	private CountryController controller;

	@Test
	public void addcountryTest() {
		
		Country country = new Country(1 ,"India" , "maharashtra");
		
		when(service.addCountry(country)).thenReturn(country);
		ResponseEntity<Country> addcountry = controller.addcountry(country);
		HttpStatus actualstatusCode = addcountry.getStatusCode();
		Country countryNew = addcountry.getBody();
		
		assertEquals("India", countryNew.getCountryName());
		assertEquals("maharashtra", countryNew.getStateName());
		assertEquals(1,countryNew.getId() );
		
		assertEquals(HttpStatus.CREATED, actualstatusCode);
	}
	
	@Test
	public void addCountryUserNotFoundExceptionTest() 
	{
		assertThrows(UserNotFoundException.class, () -> controller.addcountry(null));
	}
	
	@Test
	public void getAllCountriesTest() {
		List<Country> list = new ArrayList<>();
	    list.add(new Country(1 ,"India" , "maharashtra"));
		when(service.getAllCountries()).thenReturn(list);
		
		ResponseEntity<List<Country>> allCountries = controller.getAllCountries();
		HttpStatus actualstatusCode = allCountries.getStatusCode();
		
		List<Country> listcountries = allCountries.getBody();
		
		assertEquals(HttpStatus.FOUND, actualstatusCode);
		assertEquals(1, listcountries.size());
		
		
	}

	@Test
	public void getCountryByIdTest() {
		
		Country country = new Country(1 ,"India" , "maharashtra");
		when(service.getCountryById(1)).thenReturn(country);
		ResponseEntity<Country> countryById = controller.getCountryById(1);
		
		assertEquals(HttpStatus.FOUND, countryById.getStatusCode());
		
	}
	
	@Test
	public void getCountryByIdUserNotFoundExceptionTest() {
		
		assertThrows(UserNotFoundException.class, () -> controller.getCountryById(null));
	}
}
