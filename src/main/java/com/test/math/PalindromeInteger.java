package com.test.math;

public class PalindromeInteger {

	public static void main(String[] args) {
//		System.out.println(isPalindrome(12121)); // 1
//		System.out.println(isPalindrome(111)); // 1
//		System.out.println(isPalindrome(-111));  // 0
//		System.out.println(isPalindrome(123)); // 0
//		System.out.println(isPalindrome(3)); // 1
//		System.out.println(isPalindrome(1000021)); // 0
//		System.out.println(isPalindrome(1200001)); // 0
//		System.out.println(isPalindrome(10201)); // 1
		System.out.println(isPalindrome(90)); // 0
	}

	public static int isPalindrome(int A) {
		if (A < 0) {
			return 0;
		}
		
		int num = A;
		int reverted = 0;
		
		while (num > 0) {
			reverted = reverted*10 + num%10;
			num = num/10;
		}
		
		return Integer.valueOf(reverted).equals(A) ? 1 : 0;
    }
	
	public static int isPalindrome1(int A) {
		if (A < 0) {
			return 0;
		} else if (A < 10) {
			return 1;
		} else if (A == 10) {
			return 0;
		}
		
		int num = A;
		int divisor = -1;
		int multiple = -1;
		
		while (true) {
			divisor = getDivisor(num);
			if (divisor == 1) {
				break;
			}
			
			int temp = num;
			int currentInt = 0;
			
			while (true) {
				if (temp%10 == 0) {
					break;
				}
				
				temp--;
				currentInt++;
			}
			
			multiple = num/divisor;
			if (multiple != currentInt) {
				return 0;
			}
			
			num = num % divisor;
		}
		
		return 1;
    }

	private static int getDivisor(int num) {
		String divisor = "1";
		int len = (num + "").length();
		
		for (int i=0; i<len-1; i++) {
			divisor = divisor + "0";
		}
		
		return Integer.valueOf(divisor);
	}
}