package com.Array;
/*
 * 给定一个未排序数组(数组元素的范围是1-n)，查找缺失的那个正数，并返回这个正数，
 * 算法要求：时间复杂度O(n)，空间复杂度O(n)
 * Given[1,2,0]  return 3,
   and[3,4,-1,1] return 2. 
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		int len = A.length;
		for(int i = 0;i < len;i ++) {
			//让元素A[i]回到它本应该对应的位置A[i] - 1,比如元素3所在的位置应该是2
			while(A[i] > 0 && A[i] <= len && A[A[i] - 1] != A[i]) {
				int temp = A[A[i] - 1];  //交换顺序不能颠倒
				A[A[i] - 1] = A[i];
				A[i] = temp;
			}
		}
		//遍历一遍数组，找出对应不上的那个元素
		for(int i = 0;i < len;i ++) {
			if(A[i] != i + 1)
				return i + 1;
		}
		return len + 1;  //不缺失就返回下一个数
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3};
		System.out.println(new FirstMissingPositive().firstMissingPositive(A));
	}
}
