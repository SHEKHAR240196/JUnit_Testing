package com.junit.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeNumberTest {

	@Test
	public void primeCheckTest() {
		
		PrimeNumber primeNumber = new PrimeNumber();
		boolean checkPrime = primeNumber.checkPrime(3);
		assertTrue(checkPrime);
		
	}

}
