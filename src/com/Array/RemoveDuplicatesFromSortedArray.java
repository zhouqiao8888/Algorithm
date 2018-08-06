package com.Array;
/*
 * 删除有序数组中重复的元素（只保留一个），不能申请额外的存储空间，并返回删除后的数组长度
 * 例：A =[1,1,2,2], -> A =[1,2]
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		if(A.length == 1)
			return 1;
		int index = 1; 
		for(int i = 1;i < A.length;i ++) {
			if(A[i] != A[index - 1]) {
				A[index ++] = A[i];
			}
		}
		return index == 1 ? A.length : index;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,3,4};
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(A));
		for(int i = 0;i < A.length;i ++) {
			System.out.print(A[i] + " ");
		}
	}
}
