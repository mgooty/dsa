package com.test.arrays;

public class MinStepsInfiniteGrid {
	public static void main(String args[]) {
		int[] A = {4, 8, -7, -5, -13, 9, -7, 8};
		int[] B = {4, -15, -10, -3, -13, 12, 8, -8};
		
//		int[] A = {3, -2};
//		int[] B = {-4, -3};
		
		System.out.println(coverPoints(A, B));
	}
	
	public static int coverPoints(int[] A, int[] B) {
		int numberOfSteps = 0;
		int fromX = A[0];
		int fromY = B[0];
		
		for (int i=1; i<A.length; i++) {
			int toX = A[i];
			int toY = B[i];
			
			numberOfSteps = numberOfSteps + distance(fromX, fromY, toX, toY);
			
			fromX = toX;
			fromY = toY;
		}
		
		return numberOfSteps;
    }
	
	private static int distance(int fromX, int fromY, int toX, int toY) {
		return Math.max(Math.abs(fromY - toY), Math.abs(fromX - toX));
	}
}
