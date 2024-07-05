package com.shekhar.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeNumberTest {

	//@Test
	@ParameterizedTest
	@ValueSource(strings = {"level","madam","radar","nayan"})
	public void isPalindromeTest(String str) {
		
		PalindromeNumber palindromenumber = new PalindromeNumber();
		boolean palindrome = palindromenumber.isPalindrome(str);
		
		assertTrue(palindrome);
		
	}
	
//	@Test
//	public void isPalindromePositiveTest() {
//		
//		PalindromeNumber palindromenumber = new PalindromeNumber();
//		boolean palindrome = palindromenumber.isPalindrome("level");
//		
//		assertTrue(palindrome);
//		
//	}
//
//	@Test
//	public void isPalindromePositiveTest1() {
//		
//		PalindromeNumber palindromenumber = new PalindromeNumber();
//		boolean palindrome = palindromenumber.isPalindrome("radar");
//		
//		assertTrue(palindrome);
//		
//	}
	
//	@Test
//	public void isPalindromeNegativeTest() {
//		
//		PalindromeNumber palindromenumber = new PalindromeNumber();
//		boolean palindrome = palindromenumber.isPalindrome("Test");
//		
//		assertFalse(palindrome);
//}
	
}
