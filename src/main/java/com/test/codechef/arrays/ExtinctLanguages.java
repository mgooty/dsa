package com.test.codechef.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExtinctLanguages {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			scanner.nextInt();
			int numOfLines = scanner.nextInt();
			scanner.nextLine();
			List<String> wordsInDict = Arrays.asList(scanner.nextLine().split(" "));
			List<String> words = new ArrayList<>();
			
			for (int j=0; j<numOfLines; j++) {
				scanner.nextInt();
				words.addAll(Arrays.asList(scanner.nextLine().split(" ")));
			}
			
			for (String word: wordsInDict) {
				System.out.print(words.contains(word) ? "YES " : "NO ");
			}
			
			System.out.println();
		}
		
		scanner.close();
	}

}
