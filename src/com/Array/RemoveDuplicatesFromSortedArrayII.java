package com.Array;
/*
 * 删除有序数组中重复的元素（只保留两个），不能申请额外的存储空间，并返回删除后的数组长度
 * 例：A =[1,1,1,2,2,3], -> A =[1,1,2,2,3]
 */
public class RemoveDuplicatesFromSortedArrayII {
	//超时
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		if(A.length == 1)
			return 1;
		if(A.length == 2)
			return 2;
		int index = 0; //指向第一个相等元素的位置，之后如遇不等，指针加1
		for(int i = 1;i < A.length;) {
			if(i == A.length - 1 && A[i] == A[i - 1] && A[i] == A[i - 2]) {
				A[index ++] = A[i];
				break;
			}
			else {
				if(A[i] == A[i - 1] && A[i] == A[i + 1]) {
					if(index == 0) {
						index = i + 1;
					}
					if(i == A.length - 2) {
						i ++;
					}
					else {
						i = i + 2;
					}
				}
				else if(index != 0) {
					A[index ++] = A[i];
					i ++;
				}
			}
		}
		return index == 0 ? A.length : index;
	}
	
	//可扩展性强！根据重复的数字个数修改index取值
	public int removeDuplicates2(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		if(A.length == 1)
			return 1;
		if(A.length == 2)
			return 2;
		int index = 2;
		for(int i = 2;i < A.length;i ++) {
			if(A[i] != A[index - 2]) {
				A[index ++] = A[i];
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,1,2,2,2};
		System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates2(A));
		for(int i = 0;i < A.length;i ++) {
			System.out.print(A[i] + " ");
		}
	}
}
