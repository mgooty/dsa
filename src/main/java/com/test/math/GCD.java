package com.test.math;

public class GCD {

	public static void main(String[] args) {
//		System.out.println(gcd(20, 20));
		
		System.out.println(gcd(0, 0));
	}

	public static int gcd(int A, int B) {
		int remainder = -1;
		if (A == 0) {
			return B;
		}
		
		if (B == 0) {
			return A;
		}
		
		int num1 = -1;
		int num2 = -1;
		
		if (A > B) {
			num1 = A;
			num2 = B;
		} else {
			num1 = B;
			num2 = A;
		}
		
		while (true) {
			remainder = num1%num2;
			num1 = num2;
			
			if (remainder == 0) {
				return num1;
			}
			
			num2 = remainder;
		}
    }
}
