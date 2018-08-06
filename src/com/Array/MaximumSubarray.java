package com.Array;
/*
 *求一数组中连续子向量的最大和。例如给定数组[−2,1,−3,4,−1,2,1,−5,4],
 *返回6
 */
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if(A == null || A.length <= 0)
			return 0;
		int max = A[0];
		int sum = A[0];
		for(int i = 1;i < A.length;i ++) {
			if(sum <= 0) { //说明前面子向量都不能做贡献，另起炉灶
				sum = A[i];
			}
			else {
				sum += A[i];
			}
			max = Math.max(max, sum); 
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {-1};
		System.out.println(new MaximumSubarray().maxSubArray(A));
	}
}
