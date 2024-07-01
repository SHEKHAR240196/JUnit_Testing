package com.junit.calculator;

public class EvenOdd {
	
	public  boolean evenOdd(int number) {
		
		//int num = 10;
		 
	    // Checking if number is even or odd number
	    // via remainder
		
		if(number % 2 == 0) {
			
		 // If remainder is zero then this number is even
			System.out.println("Entered Number is Even");
			return true;
		}
		else {
			
		// If remainder is not zero then this number is
	    // odd
			System.out.println("Entered Number is Odd");
			return false;
		}
		
		
		
	}

}
