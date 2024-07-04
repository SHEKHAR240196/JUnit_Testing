package com.shekhar.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shekhar.entity.Country;
import com.shekhar.service.CountryServiceImpl;

@SpringBootTest(classes = { CountryControllerTest2.class })
@AutoConfigureMockMvc
@ContextConfiguration
@ComponentScan(basePackages = "com.shekhar.service")
class CountryControllerTest2 {

	@Mock
	private CountryServiceImpl service;
	
	@InjectMocks
	private CountryController controller;
	
	@Autowired
	MockMvc mockMvc;
	
	@BeforeEach
	public void setup() {
		mockMvc  = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void getAllCountriesTest() throws Exception {
		List<Country> list = new ArrayList<>();
		list.add(new Country(1 ,"India","maharashtra"));
		
		when(service.getAllCountries()).thenReturn(list);
		
		mockMvc.perform(get("/getAllCountries")).andExpect(status().isFound()).andDo(print());
	}
	
	@Test
	public void addCountryTest() throws Exception {
		Country country = new Country(1,"India","maharashtra");
		
		when(service.addCountry(country)).thenReturn(country);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String newCountries = mapper.writeValueAsString(country);
		

		mockMvc.perform(post("/saveUser")
			    .contentType(MediaType.APPLICATION_JSON)
			    .content(newCountries))
			    .andExpect(status().isCreated()).andDo(print());
	}
	
	@Test
	public void getCountryByIdTest() throws Exception {
		
		Country country = new Country(1,"India","maharashtra");
		
		Integer countryid=1;
		
		when(service.getCountryById(countryid)).thenReturn(country);
		
		mockMvc.perform(get("/getCountryById/{Id}",countryid)).andExpect(status().isFound())
		.andExpect(MockMvcResultMatchers.jsonPath(".id").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath(".countryName").value("India"))
		.andExpect(MockMvcResultMatchers.jsonPath(".stateName").value("maharashtra"));
		
	}
	
	@Test
	public void getCountryByNameTest() throws Exception {
		
		Country country = new Country(1,"India","maharashtra");
		
		String countryname="India";
		
		when(service.getCountryByName(countryname)).thenReturn(country);
		
		mockMvc.perform(get("/getCountryByName").param("countryname", "India"))
		.andExpect(status().isFound())
		.andExpect(MockMvcResultMatchers.jsonPath(".id").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath(".countryName").value("India"))
		.andExpect(MockMvcResultMatchers.jsonPath(".stateName").value("maharashtra")).andDo(print());
		
	}
	

}
