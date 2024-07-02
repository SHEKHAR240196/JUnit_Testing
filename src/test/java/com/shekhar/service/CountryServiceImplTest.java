package com.shekhar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.shekhar.entity.Country;
import com.shekhar.repository.CountryRepo;

@SpringBootTest(classes = {CountryServiceImplTest.class})
class CountryServiceImplTest {

	@Mock
	private CountryRepo countryRep;
	
	@InjectMocks
	private CountryServiceImpl service;
	
	@Test
	public void getAllCountriesTest() {
		List<Country> mycountries = new ArrayList<>();
		mycountries.add(new Country(101, "India", "Maharashtra"));
		mycountries.add(new Country(102, "Canada", "Barrie"));
		
		when(countryRep.findAll()).thenReturn(mycountries);
		
		List<Country> allCountries = service.getAllCountries();
		assertEquals(2, allCountries.size());
		
	}
	
	@Test
	public void getCountryByIdTest() {
		List<Country> mycoutries = new ArrayList<>();
		mycoutries.add(new Country(101, "India", "Maharashtra"));
		mycoutries.add(new Country(102, "Canada", "Barrie"));

		when(countryRep.findAll()).thenReturn(mycoutries);
		
		Integer expectedId=101;
		Integer actualId=service.getCountryById(expectedId).getId();
		assertEquals(expectedId, actualId);
		
		
	}
	@Test
	public void getCountryByNameTest() {
		List<Country> mycoutries = new ArrayList<>();
		mycoutries.add(new Country(101, "India", "Maharashtra"));
		mycoutries.add(new Country(102, "Canada", "Barrie"));

		when(countryRep.findAll()).thenReturn(mycoutries);
		
		String expectedCountryName="India";
		String actualCountryName=service.getCountryByName(expectedCountryName).getCountryName();
		
		assertEquals(expectedCountryName, actualCountryName);
		
	}
	
	@Test
	public void addCountryTest() {
		
		Country country = new Country(101, "India", "Maharashtra");

		when(countryRep.save(country)).thenReturn(country);

		Country actualCountry = service.addCountry(country);

		assertEquals("India", actualCountry.getCountryName());
		assertEquals("Maharashtra", actualCountry.getStateName());
		assertEquals(101, actualCountry.getId());
		
	}
	
	@Test
	public void updateCountryTest() {
		Country country = new Country(101, "India", "Maharashtra");

		country.setId(102);
		when(countryRep.save(country)).thenReturn(country);

		Integer id = 102;
		Country updateCountry = service.updateCountry(country, id);
		
		assertEquals(102, updateCountry.getId());
		assertEquals(country.getCountryName(), updateCountry.getCountryName());
		assertEquals(country.getStateName(), updateCountry.getStateName());
		
	}
	
	@Test
	public void deleteCountryTest() {
		Country country = new Country(101, "India","Maharashtra");
		service.deleteCountry(country);
		verify(countryRep,times(1)).delete(country);
	}

}
