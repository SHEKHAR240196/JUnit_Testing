package com.junit.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorsTest {
	
	Calculators calculators = new Calculators();
	
	
	@Test
    public void sumTest() {
		
		assertEquals(20, calculators.sum(10, 10));
    	
//    	Calculators calculators = new Calculators();
//    	int actualResult = calculators.sum(10, 10);
//    	System.out.println("Actual result  " + actualResult);
//    	int expectedResult=20;
//    	assertEquals(expectedResult, actualResult);
    	
    }
	
	@Test
	public void subTest() {
		
		assertEquals(5, calculators.sub(10, 5));
		
//		Calculators calculators = new Calculators();
//		int actualResult = calculators.sub(10, 5);
//		System.out.println("Actual result"  + actualResult);
//		int expectedResult=5;
//		assertEquals(expectedResult, actualResult);
		
  }
	
	@Test
	public void mulTest() {
		
		assertEquals(25, calculators.mul(5, 5));
		
//		Calculators calculators = new Calculators();
//		int actualResult = calculators.mul(5, 5); 
//		System.out.println("Actual result  " + actualResult);
//		int expectedResult=25;
//		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	public void divTest() {
		
		assertEquals(5, calculators.div(25, 5));
		
//		Calculators calculators = new Calculators();
//		int actualResult = calculators.div(25, 5);
//		System.out.println("actual result " +actualResult);
//		int expectedResult=5;
//		assertEquals(expectedResult, actualResult);
	}
	
}
