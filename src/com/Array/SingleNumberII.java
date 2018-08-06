package com.Array;

import java.util.Arrays;

public class SingleNumberII {
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
	
	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] A = {2,2,11,3,2,3,3};
		System.out.println(sn.singleNumber(A));
	}
}
