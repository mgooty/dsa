package com.test.codechef.dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AlternatingSubArrays {

	private static int[] memo;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numOfTestCases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numOfTestCases; i++) {
			int numOfItems = scanner.nextInt();
			memo = new int[numOfItems];
			
			List<Integer> items = new ArrayList<>();
			for (int j=0; j<numOfItems; j++) {
				int num = scanner.nextInt();
				items.add(num);
			}
			
			printAlternatingSubArrays(items, 0);
			System.out.println();
		}
		
		scanner.close();
	}

	private static void printAlternatingSubArrays(List<Integer> items, int position) {
		if (position == items.size()) {
			return;
		}
		
		if (position != 0 && memo[position - 1] != 1) {
			memo[position] = memo[position - 1]-1;
			System.out.print(memo[position - 1]-1 + " ");
		} else {
			Stack<Boolean> isNextNumPos = new Stack<>();
			for (int i=position; i<items.size(); i++) {
				if (items.get(i) < 0) {
					if (!isNextNumPos.isEmpty()) {
						if(isNextNumPos.peek()) {
							break;
						}
					}
					isNextNumPos.push(true);
				} else {
					if (!isNextNumPos.isEmpty()) {
						if(!isNextNumPos.peek()) {
							break;
						}
					}
					isNextNumPos.push(false);
				}
				memo[position] = memo[position] + 1;
			}
			
			System.out.print(isNextNumPos.size() + " ");
		}
		
		printAlternatingSubArrays(items, ++position);
	}
}
