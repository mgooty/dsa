package com.test.arrays;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
//		int[] input = {3, 30, 34, 5, 9};
//		int[] input = {10, 10, 10};
//		int[] input = {10, 20, 30, 40, 50};
//		int[] input = {9, 8, 7, 6, 5, 4};
//		int[] input = {1, 2, 3, 4, 5};
//		int[] input = {1, 1, 1, 9, 9, 9};
		int[] input = {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};
//		int[] input = {9, 11, 2}; 
		
		System.out.println(largestNumber(input));
	}
	
	public static String largestNumber(final int[] A) {
		Integer[] input = new Integer[A.length];
		for (int i=0; i<A.length; i++) {
			input[i] = A[i];
		}
		
		Arrays.sort(input, new Comparator<Integer>() {

			@Override
			public int compare(Integer num1, Integer num2) {
				
				String num1Str = num1 + "";
				String num2Str = num2 + "";
				
				BigDecimal bd1 = new BigDecimal(num1Str+num2Str);
				BigDecimal bd2 = new BigDecimal(num2Str+num1Str);
				
				return bd1.compareTo(bd2);
			}
		});
		
		if (input.length == 0) {
			return "";
		} else if (input.length == 1) {
			return input[0] + "";
		}
		
		StringBuilder result = new StringBuilder();
		for (int i=input.length-1; i>=0; i--) {
			result.append(input[i]);
		}
		
		while (result.charAt(0) == '0' && result.length() > 1)
			result.deleteCharAt(0);

		return result.toString();
    }
}
