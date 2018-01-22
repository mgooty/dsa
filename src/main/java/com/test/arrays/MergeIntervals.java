package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {

	public static void main(String[] args) {
//		Interval int1 = new Interval(1, 5);
//		Interval int2 = new Interval(10, 15);
		
		Interval int1 = new Interval(1, 2);
		Interval int2 = new Interval(3, 5);
		Interval int3 = new Interval(6, 7);
		Interval int4 = new Interval(8, 10);
		Interval int5 = new Interval(12, 16);
		
//		Interval int1 = new Interval(4396776, 43900851);
//		Interval int2 = new Interval(58085489, 69279738);
//		Interval int3 = new Interval(79427653, 83523721);
//		Interval int4 = new Interval(88972731, 93436461);
		
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(int1);
		intervals.add(int2);
		intervals.add(int3);
		intervals.add(int4);
		intervals.add(int5);
		
		Interval newInternval = new Interval(4, 9);
		
		for (Interval interval: solution(intervals, newInternval)) {
			System.out.print(interval.start + "  " + interval.end + "  ");
		}
	}

	public static ArrayList<Interval> solution(ArrayList<Interval> intervals, Interval newInterval) {
		int size = intervals.size();
		if (size == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		
		boolean inserted = false;
		for (int i = 0; i < size; i++) {
			Interval iIter = intervals.get(i);
			if (iIter.start > newInterval.start) {
				intervals.add(i, newInterval);
				inserted = true;
				break;
			}
		}
		
		if (!inserted) {
			intervals.add(newInterval);
		}
		
		// merge and return
		return merge(intervals);
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> a) {
        Stack<Interval> st = new Stack<Interval>();
        st.push(a.get(0));
        
        for(int i=1;i<a.size();i++) {
            Interval top = st.peek();
            Interval iterInt = a.get(i);
            if(top.end>= iterInt.start) {
                Interval newInt = mergeIntervals(top, iterInt);
                st.pop();
                st.push(newInt);
            }
            else {
                st.push(iterInt);
            }
        }
        ArrayList<Interval> answer = new ArrayList<Interval>();
        while(!st.isEmpty()) {
           answer.add(st.pop());
        }
        Collections.reverse(answer);
        return answer;
    }

	public static Interval mergeIntervals(Interval a, Interval b) {
		int min = Math.min(a.start, b.start);
		int max = Math.max(a.end, b.end);
		return (new Interval(min, max));
	}
    
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> newIntervals = new ArrayList<>();
		if (intervals.isEmpty()) {
			newIntervals.add(newInterval);
			return newIntervals;
		}
		
		int start = newInterval.start;
		int end = newInterval.end;
		
		boolean isStartSet = false;
		boolean isEndSet = false;
		if (end < intervals.get(0).start) {
			newIntervals.add(newInterval);
			isStartSet = true;
			isEndSet = true;
		}
		
		Interval mergeInterval = null; 
		for (int i=0; i<intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (isOverlapping(interval, newInterval)) {
				if (mergeInterval == null) {
					mergeInterval = new Interval();
					mergeInterval.start = Math.min(start, intervals.get(i).start);
					isStartSet = true;
					newIntervals.add(mergeInterval);
				} else if (end > interval.start) {
					mergeInterval.end = Math.max(end, intervals.get(i).end);
				}
			} else {
				if (i+1<=intervals.size()-1 && start > intervals.get(i).end && end <intervals.get(i+1).start) {
					if (mergeInterval == null) {
						mergeInterval = new Interval();
					}
					mergeInterval.start = start;
					mergeInterval.end = end;
					isStartSet = true;
					isEndSet = true;
					
					newIntervals.add(intervals.get(i));
					newIntervals.add(mergeInterval);
				} else {
					newIntervals.add(intervals.get(i));
				}
			}

			if (mergeInterval == null) {
				continue;
			}
			
			if (!isEndSet) {
				if (end < interval.start) {
					mergeInterval.end = end;
					isEndSet = true;
				} else if (end < interval.end) {
					mergeInterval.end = interval.end;
					isEndSet = true;
				} else if (end > interval.end) {
					mergeInterval.end = end;
					isEndSet = true;
				}
			}
		}

		if (start > intervals.get(intervals.size()-1).end) {
			newIntervals.add(newInterval);
		}
		
		return newIntervals;
	}
	
	public static ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> newIntervals = new ArrayList<>();
		if (intervals.isEmpty()) {
			newIntervals.add(newInterval);
			return newIntervals;
		}
		
		int start = newInterval.start;
		int end = newInterval.end;
		
		List<Integer> overLappingIntervalIndexes = new ArrayList<>();
		for (int i=0; i<intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (isOverlapping(interval, newInterval)) {
				overLappingIntervalIndexes.add(i);
			}
		}

		if (overLappingIntervalIndexes.isEmpty()) {
			if (end < intervals.get(0).start) {
				newIntervals.add(newInterval);
			}
		}
		
		Interval mergeInterval = new Interval(); 
		for (int i=0; i<intervals.size(); i++) {
			if (overLappingIntervalIndexes.contains(i)) {
				if (overLappingIntervalIndexes.get(0) == i) {
					if (overLappingIntervalIndexes.size() == 1) {
						mergeInterval.start = Math.min(start, intervals.get(i).start);
						mergeInterval.end = Math.max(end, intervals.get(i).end);
						newIntervals.add(mergeInterval);
					} else {
						mergeInterval.start = Math.min(start, intervals.get(i).start);
						newIntervals.add(mergeInterval);
					}
				} else {
					if (overLappingIntervalIndexes.get(overLappingIntervalIndexes.size()-1) == i) {
						mergeInterval.end = Math.max(end, intervals.get(i).end);
					}
				}
			} else if (overLappingIntervalIndexes.isEmpty()) {
				if (i+1<=intervals.size()-1 && start > intervals.get(i).end && end <intervals.get(i+1).start) {
					mergeInterval.start = start;
					mergeInterval.end = end;
					newIntervals.add(intervals.get(i));
					newIntervals.add(mergeInterval);
				} else {
					newIntervals.add(intervals.get(i));
				}
			} else {
				newIntervals.add(intervals.get(i));
			}
		}
		
		if (overLappingIntervalIndexes.isEmpty()) {
			if (start > intervals.get(intervals.size()-1).end) {
				newIntervals.add(newInterval);
			}
		}
		
		return newIntervals;
	}
	
	private static boolean isOverlapping(Interval interval, Interval newInterval) {
		return !((interval.start > newInterval.end) || (interval.end < newInterval.start));
	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
