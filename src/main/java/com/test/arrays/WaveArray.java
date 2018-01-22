package com.test.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaveArray {

	public static void main(String[] args) {
//		int[] input = {1, 2, 3, 4};
//		int[] input = {1, 2, 2, 4}; // 2 1 4 2
//		int[] input = {1, 2, 2, 2, 4}; // 2 1 2 2 4
		int[] input = {1, 1, 2, 2};
		
		int[] output = wave(input);
		for (int i=0; i<output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}

	public static int[] wave(int[] A) {
		List<Integer> items = new ArrayList<>();
		for (int i=0; i<A.length; i++) {
			items.add(A[i]);
		}
		
		Collections.sort(items);
		
		for (int i=0; i<A.length; i++) {
			if (i < (items.size()-1)) {
				Integer temp = items.get(i);
				items.set(i, items.get(i+1));
				items.set(i+1, temp);
				
				i++;
			}
		}
		
		int[] result = new int[items.size()];
		for (int i=0; i<A.length; i++) {
			result[i] = items.get(i);
		}
		
		return result;
    }
}
