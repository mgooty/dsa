package com.test.codechef.arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RainbowNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			int numOfElements = scanner.nextInt();
			boolean isEven = numOfElements % 2 == 0 ? true : false;
			int midIndex = isEven ? numOfElements / 2 : (numOfElements / 2) + 1;
			midIndex = midIndex - 1;
			
			List<Integer> items = new ArrayList<>();
			boolean isRainbow = true;
			int prevItem = -1;
			for (int j=0; j<numOfElements; j++) {
				int item = scanner.nextInt();
				if (item < 1 || item > 10) {
					isRainbow = false;
					break;
				}
				
				if (j > midIndex) {
					int distanceFromMid = 0;
					if (isEven) {
						distanceFromMid = j-midIndex-1;
					} else {
						distanceFromMid = j-midIndex;
					}
					
					if (items.get(midIndex - distanceFromMid) != item) {
						isRainbow = false;
						break;
					}
				} else {
					items.add(item);
					
					if (prevItem == -1) {
						prevItem = item;
					} else if (item - prevItem != 0 && item - prevItem != 1) {
						isRainbow = false;
						break;
					} else {
						prevItem = item;
					}
				}
			}
			
			scanner.nextLine();
			System.out.println(isRainbow ? "yes" : "no");
		}
		
		scanner.close();
	}

}
