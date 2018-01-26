package com.test.codechef.arrays;
import java.util.Scanner;

public class MutedMinions {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			int numOfMinions = scanner.nextInt();
			int incrementBy = scanner.nextInt();
			
			int result = 0;
			for (int j=0; j<numOfMinions; j++) {
				int item = scanner.nextInt();
				
				if ((item + incrementBy)%7 == 0) {
					result++;
				}
			}
			
			System.out.println(result);
		}
		
		scanner.close();
	}

}
