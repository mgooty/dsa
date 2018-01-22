package com.test.math;

public class PrimeSum {

	public static void main(String[] args) {
		int result[] = primesum(102);
		System.out.println(result[0] + "    " + result[1]);
	}
	
	public static int[] primesum(int A) {
		for (int i=2; i<=A; i++) {
			if (i == 2 || (i%2 != 0 && isPrime(i))) {
				int secondNum = A - i;
				if (isPrime(secondNum)) {
					return new int[]{i, secondNum};
				}
			}
		}
		
		return null;
    }
	
	public static boolean isPrime(int num) {
		for (int i=2; i<num; i++) {
			if (num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
