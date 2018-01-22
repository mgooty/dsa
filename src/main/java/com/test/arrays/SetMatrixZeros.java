package com.test.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

	public static void main(String[] args) {
		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(0);
		row1.add(1);
		row1.add(1);
		
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(1);
		row2.add(1);
		row2.add(1);
		
		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(1);
		row3.add(1);
		row3.add(0);
		
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		input.add(row1);
		input.add(row2);
		input.add(row3);
		
		System.out.println("INPUT ====> ");
		for (int i=0; i<input.size(); i++) {
			ArrayList<Integer> item = input.get(i);
			for (int j=0; j<item.size(); j++) {
				System.out.print(item.get(j) + "   ");
			}
			
			System.out.println();
		}
		
		setZeroes(input);
		
		System.out.println("OUTPUT ====> ");
		for (int i=0; i<input.size(); i++) {
			ArrayList<Integer> item = input.get(i);
			for (int j=0; j<item.size(); j++) {
				System.out.print(item.get(j) + "   ");
			}
			
			System.out.println();
		}
	}
	
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a.isEmpty()) {
			return;
		}
		
		Set<Integer> zeroRows = new HashSet<>();
		Set<Integer> zeroCols = new HashSet<>();
		
		for (int i=0; i<a.size(); i++) {
			ArrayList<Integer> item = a.get(i);
			for (int j=0; j<item.size(); j++) {
				Integer num = item.get(j);
				
				if (num == 0) {
					zeroRows.add(i);
					zeroCols.add(j);
				}
			}
		}
		
		update(a, zeroRows, zeroCols);
	}
	
	public static void update(ArrayList<ArrayList<Integer>> input, Set<Integer> zeroRows, Set<Integer> zeroCols) {
		for (int i=0; i<input.size(); i++) {
			ArrayList<Integer> row = input.get(i);
			if (zeroRows.contains(i)) {
				for (int j=0; j<row.size(); j++) {
					row.set(j, 0);
				}
			}
			
			for (int k=0; k<row.size(); k++) {
				if (zeroCols.contains(k)) {
					row.set(k, 0);
				}
			}
		}
	}
}
