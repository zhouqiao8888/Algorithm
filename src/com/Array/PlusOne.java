package com.Array;
/*
 * 某个数的各数位存在数组里，将这个数加1后仍以数组的形式返回
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length <= 0)
			return digits;
		int add = 1; //进位
		for(int i = digits.length - 1;i >= 0;i --) {
			int temp = (digits[i] + add) % 10;
			add = (digits[i] + add) / 10;
			digits[i] = temp;
		}
		//System.out.println(add);
		if(add == 1) { //如果最后仍存在进位，说明出现了9999 + 1 = 10000这种情况
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
		else {
			return digits;
		}
	}
	
	public static void main(String[] args) {
		int[] digits = {9,8};
		int[] res = new PlusOne().plusOne(digits);
		for(int i = 0;i < res.length;i ++) {
			System.out.print(res[i] + " ");
		}
	}
}
