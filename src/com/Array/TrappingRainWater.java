package com.Array;
/*
 * 给定一个数组，代表一个柱状图，宽为1，高为数组元素大小，问该柱状图能困住雨水的容量
 * Given[0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 */
public class TrappingRainWater {
	//遍历一次
	public int trap(int[] A) {
		if(A.length <= 0) {
			return 0;
		}
		int leftMax = A[0];	//左边最大高度
		int rightMax = A[A.length - 1];	//右边最大高度
		int i = 0;   //左边游标
		int j = A.length - 1;	//右边游标
		int max = 0;
		while(i < j) {
			if(A[i] < A[j]) {
				max += Math.max(0, leftMax - A[i]);
				leftMax = Math.max(leftMax, A[i]);
				i ++;
			}
			else {
				max += Math.max(0, rightMax - A[j]);
				rightMax = Math.max(rightMax, A[j]);
				j --;
			}
		}
		return max;
	}
	
	//遍历两次
	public int trap2(int[] A) {
		if(A.length <= 0) {
			return 0;
		}
		//寻找最大值下标
		int maxIndex = 0;
		for(int i = 0;i < A.length;i ++) {
			if(A[i] > A[maxIndex]) {
				maxIndex = i;
			}
		}
		int max = 0;
		//求左边容量
		int leftMax = A[0];
		for(int i = 0;i < maxIndex;i ++) {
			if(leftMax > A[i]) {
				max += leftMax - A[i];
			}
			else {
			    leftMax = A[i];
			}
		}
		//求右边容量
		int rightMax = A[A.length - 1];
		for(int i = A.length - 1;i > maxIndex;i --) {
			if(rightMax > A[i]) {
				max += rightMax - A[i];
			}
			else {
				rightMax = A[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(A));
	}
}
