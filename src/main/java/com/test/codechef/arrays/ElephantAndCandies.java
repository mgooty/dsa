package com.test.codechef.arrays;

import java.util.Scanner;

public class ElephantAndCandies {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			int numOfElephants = scanner.nextInt();
			int numOfCandies = scanner.nextInt();
			scanner.nextLine();
			
			int totalCandies = 0;
			for (int j=0; j<numOfElephants; j++) {
				totalCandies = totalCandies + scanner.nextInt();
			}
			
			if (totalCandies <= numOfCandies) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
			scanner.nextLine();
		}

		scanner.close();
	}
}
