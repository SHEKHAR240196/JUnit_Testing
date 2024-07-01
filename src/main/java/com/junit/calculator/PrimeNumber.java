package com.junit.calculator;

public class PrimeNumber {
	
	static boolean checkPrime(int n) {
		int i,m=0,flag=0;
		m=n/2;
		
		if(n==0 || n==1) {
			System.out.println(n+ "is not prime number");
			return false;
		}
		else {
			for(i=2 ; i<=m ; i++) {
				if(n % i ==0) {
					System.out.println(n + "is not prime number");
					flag=1;
					return false;
				}
				
			}
			if(flag==0) {
				System.out.println(n + "is prime number");
				return true;
			}
			
		}//end of else
		return true;
		
	}

}
