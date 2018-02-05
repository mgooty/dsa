package com.test.codechef.strings;
import java.util.Scanner;

public class Lapindromes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			String str = scanner.nextLine();
			
			int[] firstHalfCounters = new int[26];
			int[] secondHalfCounters = new int[26];
			
			char[] chars = str.toCharArray();
			boolean ignoreMiddleItem = chars.length%2 != 0;
			int middleIdx = chars.length/2;
			for (int j=0; j<chars.length; j++) {
				if (ignoreMiddleItem && j == middleIdx) {
					continue;
				}
				
				if (j < middleIdx) {
					firstHalfCounters[chars[j] - 'a']++;
				} else {
					secondHalfCounters[chars[j] - 'a']++;
				}
			}
			
			String result = "YES";
			for (int k=0; k<26; k++) {
				if (firstHalfCounters[k] != secondHalfCounters[k]) {
					result = "NO";
				}
			}
			
			System.out.println(result);
		}
		
		scanner.close();
	}
}
