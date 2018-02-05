package com.test.codechef.strings;

import java.math.BigDecimal;
import java.util.Scanner;

public class CountingSubStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			int numOfChars = scanner.nextInt();
			scanner.nextLine();
			char[] chars = scanner.nextLine().toCharArray();
			
			int numOfOnes = 0;
			for (int j=0; j<numOfChars; j++) {
				char item = chars[j];
				
				if (item == '1') {
					numOfOnes++;
				}
			}
			
			System.out.println(new BigDecimal(numOfOnes).add(new BigDecimal("1")).multiply(new BigDecimal(numOfOnes)).divide(new BigDecimal("2")));
		}
		
		scanner.close();
	}
}
