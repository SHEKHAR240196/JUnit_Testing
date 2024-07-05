package com.shekhar.exception;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class EvenOddNumberTest {

	//@Test
	@ParameterizedTest
	//@CsvSource({"2, even","4, even","6, even","8, even"})
	  @CsvFileSource(resources = "/test1.csv", numLinesToSkip = 1)
	public void evenorOddNumTest(String input ,String expected) {
		
		EvenOddNumber evenOddNumber = new EvenOddNumber();
		
		String actualResult = evenOddNumber.evenorOddNum(Integer.parseInt(input));
		
		assertEquals(expected, actualResult );
	
		
	}

}
