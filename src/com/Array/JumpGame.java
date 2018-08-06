package com.Array;
/*
 * 给定一个数组，数组中的每个元素代表可以跳跃的最大步数，
 * 一个机器人位于数组的起点，判断它能否跳跃到数组的终点
 * A =[2,3,1,1,4], return true. 
   A =[3,2,1,0,4], return false. 
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if(A == null || A.length <= 0)
			return false;
		int max = 0; //可以跳跃到的最大下标
		for(int i = 0;i < A.length && i <= max;i ++) {
			max = Math.max(max, i + A[i]);
		}
		System.out.println("max:" + max);
		return max >= A.length - 1 ? true : false;
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,1,0,4};
		System.out.println(new JumpGame().canJump(A));
	}
}
