package com.Array;

import java.util.Arrays;

//找出数组中仅出现一次的那个数字,其他数字均出现2次
public class SingleNumber {
	//时间复杂度：O(nlogn),空间复杂度：O(1)
	public int singleNumber(int[] A) {
		if(A == null || A.length == 0)
			return -1;
		if(A.length == 1)
			return A[0];
        Arrays.sort(A);
        for(int i = 0;i < A.length;i ++) {
        	if(i == 0 && A[i] != A[i + 1]) {
        		return A[i];
        	}       	
        	if(i > 0 && i < A.length - 1 
        	   && A[i] != A[i - 1] && A[i] != A[i + 1]) {
        		return A[i];
        	}        	
        	if(i == A.length - 1 && A[i] != A[i - 1]) {
        		return A[i];
        	}
        }
        return -1;       
    }
	
	/*异或思路：时间复杂度O(n)，空间复杂度O(1)
	 *0与任何数异或还是它本身，相同的数异或为0
	 *2^1^2^3^3 = 2^2^3^3^1 = 1
	 */
	public int singleNumber2(int[] A) {
		if(A == null || A.length == 0)
			return -1;
		if(A.length == 1)
			return A[0];
		int res = 0;
		for(int i = 0;i < A.length;i ++) {
			res ^= A[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		int[] A = {2,11,3,2,3};
		System.out.println(sn.singleNumber2(A));
	}
}
