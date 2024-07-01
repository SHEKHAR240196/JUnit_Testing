package com.shekhar.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shekhar.services.WelcomeService;

@WebMvcTest(value = WelcomeController.class)
class WelcomeControllerTest {
	
	@MockBean
	private WelcomeService service;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void WelcomemsgTest() throws Exception {
		
		when(service.welcomeMsg()).thenReturn("Welcome to bikkadIt");
		
		//Request get
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/welcome");
		
		ResultActions perform = mockMvc.perform(request);
		
		//Taking the result from MOCKMVC
		MvcResult mockresult = perform.andReturn();
		
		//status code
		MockHttpServletResponse response = mockresult.getResponse();
		
		int status = response.getStatus();
		System.out.println(status);
		
		assertEquals(200, status);
	
		
		
	}
}
