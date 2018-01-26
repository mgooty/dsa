package com.test.codechef.arrays;
import java.util.Scanner;

public class ChefNoteBook {

	/**
	 *	X - number of pages to poetry to be written	 
	 * 	Y - number of pages left
	 * 	K - number of rubles left to buy a book
	 * 	N - number of books shown by shopkeeper
	 * 	Pi - number of pages in the ith book
	 * 	Ci - price of the ith book
	 * 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			int pagesToWrite = scanner.nextInt();
			int pagesLeft = scanner.nextInt();
			int rublesAvailable = scanner.nextInt();
			int N = scanner.nextInt();
			
			int numOfPagesRequired = pagesToWrite - pagesLeft;
			boolean isLucky = false;
			for (int j=0; j<N; j++) {
				int numOfPages = scanner.nextInt();
				int price = scanner.nextInt();
				
				if (price <= rublesAvailable && numOfPages >= numOfPagesRequired) {
					isLucky = true;
				}
			}
			
			if (isLucky) {
				System.out.println("LuckyChef");
			} else {
				System.out.println("UnluckyChef");
			}
			
			scanner.nextLine();
		}
		
		scanner.close();
	}

}
