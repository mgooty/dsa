package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingInteger {

	public static void main(String[] args) {
		int[] input = {699, 2, 690, 936, 319, 784, 562, 35, 151, 698, 126, 730, 587, 157, 201, 761, 956, 359, 198, 986, 915, 7, 703, 324, 814, 382, 294, 204, 120, 731, 615, 330, 486, 52, 223, 376, 649, 458, 564, 971, 72, 605, 177, 20, 461, 790, 872, 363, 916, 435, 991, 184, 410, 320, 16, 480, 768, 801, 117, 338, 650, 786, 17, 369, 979, 304, 445, 688, 862, 229, 311, 351, 985, 697, 135, 299, 310, 3, 643, 221, 831, 196, 887, 679, 484, 209, 824, 292, 588, 721, 140, 675, 827, 913, 271, 170, 812, 552, 334, 860, 981, 550, 308, 584, 442, 328, 251, 456, 976, 31, 507, 954, 982, 742, 45, 727, 794, 309, 527, 623, 56, 843, 436, 681, 143, 130, 689, 870, 362, 580, 560, 474, 385, 525, 881, 51, 890, 917, 820, 826, 139, 443, 978, 144, 512, 205, 682, 188, 344, 429, 497, 181, 749, 864, 664, 145, 621, 629, 886, 572, 89, 725, 945, 29, 553, 977, 783, 590, 236, 728, 125, 90, 492, 261, 543, 259, 662, 622, 285, 392, 561, 670, 200, 504, 246, 513, 910, 583, 460, 179, 207, 709, 127, 926, 816, 426, 520, 174, 464, 883, 780, 5, 268, 606, 1, 109, 704, 391, 661, 924, 516, 241, 477, 952, 405, 522, 247, 335, 356, 839, 423, 779, 4, 43, 720, 238, 965, 951, 914, 10, 496, 775, 651, 788, 373, 491, 746, 799, 518, 93, 86, 774, 652, 955, 494, 252, 781, 946, 412, 202, 741, 719, 612, 673, 896, 1000, 289, 554, 69, 424, 980, 506, 593, 889, 25, 959, 28, 736, 8, 969, 865, 657, 567, 434, 9, 167, 357, 929, 645, 250, 565, 94, 928, 473, 509, 823, 313, 762, -1, 208, 903, 922, 655, 948, 326, 485, 150, 73, 505, 225, 122, 129, 648, 838, 811, 972, 735, 78, 428, 740, 782, 632, 316, 440, 737, 297, 873, 281, 479, 654, 0, 633, 212, 152, 154, 470, 866, 79, 722, 958, 732, 900, 832, 278, 58, 842, 745, 540, 169, 347, 592, 438, 882, 462, 53, 34, 519, 489, 85, 757, 919, 701, 15, 211, 667, 637, 74, 573, 240, 559, -2, 472, 203, 112, 162, 776, -4, 155, 837, 99, 98, 64, 101, 983, 366, 853, 970, 482, 40, 921, 374, 758, 413, 339, 705, 771, 360, 734, 282, 219, 766, 535, 133, 532, 254};
//		Integer[] input = { 4, 0, 5, 2, 1, 9, 10};
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(0);
		list.add(5);
		list.add(2);
		list.add(1);
		list.add(-9);
		list.add(-10);
		
		System.out.println(firstMissingPositive(input));
	}
	
	public static int firstMissingPositive(ArrayList<Integer> A) {
		int n = A.size() + 1;
		int count;
		int idx = 0;
		int size = A.size();
		count = size - 1;

		for (idx = size - 1; idx >= 0; idx--) {
			int num = A.get(idx);
			if (num < 0) {
				int val = A.get(count);
				A.set(idx, val);
				A.set(count, num);
				count--;
			}
		}

		for (idx = 0; idx <= count; idx++) {
			int num = A.get(idx);
			num = Math.abs(num);
			if (num > 0 && num < n) {
				int index = num - 1;
				int val = A.get(index);
				A.set(index, -val);
			}
		}

		for (idx = 0; idx <= count; idx++) {
			int num = A.get(idx);
			if (num > 0) {
				return idx + 1;
			}
		}
		
		return idx + 1;
	}

	public static int firstMissingPositive(int[] A) {
		if (A.length == 0) {
			return 1;
		} else if (A.length == 1) {
			if (A[0] > 1) {
				return 1;
			} else if (A[0] == 1) {
				return 2;
			}
		}
		
		for (int i=0; i<A.length; i++) {
			if (A[i] > 0 && A[i] <= A.length) {
				int temp = A[A[i]-1];
				if (temp != A[i]) {
					A[A[i]-1] = A[i];
					A[i] = temp;
					
					i--;
				}
			}
		}
		
		int i=0;
		for (; i<A.length; i++) {
			if (A[i] != (i+1)) {
				return i+1;
			}
		}
		
		return i+1;
	}
	
	/*public static int firstMissingPositive(int[] A) {
		if (A.length == 0) {
			return 1;
		} else if (A.length == 1) {
			if (A[0] > 1) {
				return 1;
			} else if (A[0] == 1) {
				return 2;
			}
		}
		
		List<Integer> items = new ArrayList<>(A.length);
		int smallestPosNum = 1;
		for (int i: A) {
			if (i > 0) {
				items.add(i);
				if (i < smallestPosNum) {
					smallestPosNum = i;
				}
			}
		}
		
		if (smallestPosNum > 1) {
			return 1;
		} else if (smallestPosNum == 0) {
			return 1;
		}
		
		if (items.isEmpty()) {
			return 1;
		} else if (items.size() == 1) {
			int firstVal = items.iterator().next();
			if (firstVal > 1) {
				return 1;
			} else {
				return 2;
			}
		}
		
		Collections.sort(items);
		int firstVal = items.iterator().next();
		if (firstVal > 1) {
			return 1;
		}
		
		Integer[] itemsArray = items.toArray(new Integer[0]);
		int missingPositiveNum = itemsArray[0] + 1;
		for (int i=1; i<itemsArray.length; i++) {
			if (itemsArray[i] != missingPositiveNum) {
				return missingPositiveNum;
			}
			missingPositiveNum += 1;
		}
		
		return missingPositiveNum;
    }*/

	/*public static int firstMissingPositive(int[] A) {
		Set<Integer> items = new TreeSet<>();
		
		for (int i: A) {
			if (i > 0) {
				items.add(i);
			}
		}
		
		if (items.isEmpty()) {
			return 1;
		} else if (items.size() == 1) {
			int firstVal = items.iterator().next();
			if (firstVal > 1) {
				return 1;
			} else {
				return 2;
			}
		} else {
			int firstVal = items.iterator().next();
			if (firstVal > 1) {
				return 1;
			}
		}
		
		Integer[] itemsArray = items.toArray(new Integer[0]);
		int missingPositiveNum = itemsArray[0] + 1;
		for (int i=1; i<itemsArray.length; i++) {
			if (itemsArray[i] != missingPositiveNum) {
				return missingPositiveNum;
			}
			missingPositiveNum += 1;
		}
		
		return missingPositiveNum;
    }*/
}
