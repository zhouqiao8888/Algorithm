package com.Array;
/*
 * 三原色排序：一个数组仅包含0,1,2三种数字,
 * 通过排序使得0全部位于数组前面，1全部位于数组中间，2全部位于数组后面
 * 001112222
 * 注：主要是中间指针
 */
public class SortColors {
	public void sortColors(int[] A) {
		int start = 0; //指向0元素
		int middle = 0; //指向1元素
		int end = A.length - 1; //指向2元素
		while(start <= middle && middle <= end) {
			if(A[middle] == 1)
				middle ++;
			else if(A[middle] == 0) {
				swap(A, start, middle);
				start ++;
				middle ++;
			}
			else {
				swap(A, middle, end);
				end --;
			}
		}
	}
	
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,2,2,1,0,0,2,1};
		new SortColors().sortColors(A);
		for(int i = 0;i < A.length;i ++) {
			System.out.print(A[i] + " ");
		}
	}
}
