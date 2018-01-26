package com.test.math;

public class ReverseInteger {

	public static void main(String[] args) {
//		System.out.println(reverse(0000));
//		System.out.println(reverse(123));
//		System.out.println(reverse(999999999));
//		System.out.println(reverse(2147483647));
//		System.out.println(reverse(-2147483648));
		System.out.println(reverse(-1146467285));
		
//		System.out.println(-582764641*10);
//		System.out.println(-214748364*20);
	}

	public static int reverse(int A) {
		if (A == 0) {
			return 0;
		}
		
		int reverseNum = 0;
		boolean isNeg = false;
		int temp = A;
		if (A < 0) {
			isNeg = true;
			temp = Math.abs(A);
			if (temp < 0) {
				return 0;
			}
		}
		
		while (true) {
			int rem = temp%10;
			temp = temp/10;
			reverseNum = reverseNum*10 + rem;
			
			if (temp < 10) {
				int temp1 = 0;
				if (isNeg) {
					temp1 = reverseNum * -1;
				} else {
					temp1 = reverseNum;
				}
				if (isOverflow(temp1)) {
					return 0;
				}
				
				reverseNum = reverseNum*10 + temp;
				break;
			}
		}
		
		return isNeg ? reverseNum*-1 : reverseNum;
    }
	
	public static boolean isOverflow(int num) {
		try {
			Math.multiplyExact(num, 10);
			return false;
		} catch (Exception e) {
			return true;
		}
		
		/*if (num > 0) {
			return num*10 < 0;
		} else {
			return num*10 >= 0;
		}*/
	}
}
