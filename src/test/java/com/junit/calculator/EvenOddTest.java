package com.junit.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvenOddTest {
	
	EvenOdd evenOdd = new EvenOdd();

	@Test
	public void evenOddPositiveTest (){
		
		assertTrue(evenOdd.evenOdd(4));
		
//		EvenOdd evenOdd = new EvenOdd();
//		boolean actualResult = evenOdd.evenOdd(5);	
//		boolean expectedResult=false;
//		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void evenOddNegativeTest() {
		
		assertFalse(evenOdd.evenOdd(7));
	}
}
