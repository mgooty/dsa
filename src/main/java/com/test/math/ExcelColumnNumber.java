package com.test.math;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

	public static void main(String[] args) {
//		System.out.println(titleToNumber("Z"));
		System.out.println('A' + 2);
	}

	public static int titleToNumber(String A) {
		Map<String, Integer> stringToNum = setUp();
		
		int result = 0;
		int pow = 0;
		for (int i=A.length()-1; i>=0; i--) {
			String letter = A.charAt(i) + "";
			
			result = (int) (result + (stringToNum.get(letter) * Math.pow(26, pow)));
			pow++;
		}
		
		return result;
    }

	private static Map<String, Integer> setUp() {
		Map<String, Integer> stringToNum = new HashMap<>();
		stringToNum.put("A", 1);
		stringToNum.put("B", 2);
		stringToNum.put("C", 3);
		stringToNum.put("D", 4);
		stringToNum.put("E", 5);
		stringToNum.put("F", 6);
		stringToNum.put("G", 7);
		stringToNum.put("H", 8);
		stringToNum.put("I", 9);
		stringToNum.put("J", 10);
		stringToNum.put("K", 11);
		stringToNum.put("L", 12);
		stringToNum.put("M", 13);
		stringToNum.put("N", 14);
		stringToNum.put("O", 15);
		stringToNum.put("P", 16);
		stringToNum.put("Q", 17);
		stringToNum.put("R", 18);
		stringToNum.put("S", 19);
		stringToNum.put("T", 20);
		stringToNum.put("U", 21);
		stringToNum.put("V", 22);
		stringToNum.put("W", 23);
		stringToNum.put("X", 24);
		stringToNum.put("Y", 25);
		stringToNum.put("Z", 26);
		
		return stringToNum;
	}
}
