package com.Array;
/*
 *给定一个数组和一个元素，移除该数组中所有该元素，例如[1,2,3,4],1 得[4,2,3]
 *返回新数组的长度
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int n = A.length;
		for(int i = 0;i < n;i ++) {
			if(A[i] == elem) {
				swap(A, i --, -- n);  //跟最后一个元素交换
			}
		}
		return n;
	}
	
	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int elem = 1;
		System.out.println(new RemoveElement().removeElement(A, elem));
		for(int i = 0;i < A.length;i ++) {
			System.out.print(A[i] + " ");
		}
	}
}
