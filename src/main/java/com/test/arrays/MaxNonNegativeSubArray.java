package com.test.arrays;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
//		int[] input = {1, 2, 5, -7, 5, 2, 1};
//		int[] input = {1, 2, 5, -7, -5, 2, 1}; // 1 2 5
//		int[] input = {1, 1, 1, 1, 1, 1, 1};
//		int[] input = {-1, -1, -1, -1, -1, -1, -1};
//		int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
//		int[] input = {1477171087};
//		int[] input = {-75249, 43658, 11272, -50878, 37709, 38165, -43042, -22503}; // 37709 38165 
		int[] input = {336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421}; // 1101513929 1315634022 
//		int[] input = {756898537, -1973594324, -2038664370, -184803526, 1424268980}; // 1424268980
		
		int[] result = maxset(input);
		
		for (int i=0; i<result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] maxset(int[] A) {
		BigDecimal maxSubArraySum = new BigDecimal("0");
		BigDecimal subArraySum = new BigDecimal("0");
		
		SubArray subArray = null;
		SubArray maxSubArray = null;
		for (int i=0; i<A.length; i++) {
			if (A[i] < 0) {
				if (maxSubArray == null && subArray != null) {
					maxSubArray = subArray;
					maxSubArraySum = subArraySum;
				} else if (subArray != null) {
					if (maxSubArraySum.compareTo(subArraySum) == -1) {
						maxSubArraySum = subArraySum;
						maxSubArray = subArray;
					} else if (maxSubArraySum == subArraySum) {
						if (maxSubArray.length < subArray.length) {
							maxSubArray = subArray;
							maxSubArraySum = subArraySum;
						} else if (maxSubArray.length == subArray.length && 
								maxSubArray.startIndex > subArray.startIndex) {
							maxSubArray = subArray;
							maxSubArraySum = subArraySum;
						}
					}
				} 
				
				subArraySum = new BigDecimal("0");
				subArray = null;
			} else {
				if (subArray == null) {
					subArray = new SubArray();
					subArray.startIndex = i;
				}
				
				subArraySum = subArraySum.add(new BigDecimal(A[i])); 
				subArray.items.add(A[i]);
			}
		}
		
		if (maxSubArray == null && subArray != null) {
			maxSubArray = subArray;
			maxSubArraySum = subArraySum;
		} else if (subArray != null) {
			if (maxSubArraySum.compareTo(subArraySum) == -1) {
				maxSubArraySum = subArraySum;
				maxSubArray = subArray;
			} else if (maxSubArraySum == subArraySum) {
				if (maxSubArray.length < subArray.length) {
					maxSubArray = subArray;
					maxSubArraySum = subArraySum;
				} else if (maxSubArray.length == subArray.length && 
						maxSubArray.startIndex > subArray.startIndex) {
					maxSubArray = subArray;
					maxSubArraySum = subArraySum;
				}
			}
		} 
		
		subArraySum = new BigDecimal("0");
		subArray = null;
		
		if (maxSubArray == null) {
			return new int[]{};
		}
		
		int[] result = new int[maxSubArray.items.size()];
		for (int j=0; j<result.length; j++) {
			result[j] = maxSubArray.items.get(j);
		}
		
		return result;
    }
	
	public static class SubArray {
		int length;
		
		int startIndex;
		
		int sum;
		
		List<Integer> items = new ArrayList<>();
	}
}
