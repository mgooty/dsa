package com.test.codechef.arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			int numOfWorkers = scanner.nextInt();
			
			int minWage = 10000;
			List<Integer> wages = new ArrayList<>();
			int sum = 0;
			for (int j=0; j<numOfWorkers; j++) {
				int wage = scanner.nextInt();
				if (wage < minWage) {
					minWage = wage;
				}
				
				wages.add(wage);
				sum = sum + wage;
			}
			
			System.out.println(sum - (numOfWorkers * minWage));
		}
		
		scanner.close();
	}

}
