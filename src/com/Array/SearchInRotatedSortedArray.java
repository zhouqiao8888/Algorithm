package com.Array;
/*
 * 在一个旋转有序数组中查找某个数，返回下标，如果没有，返回-1
 * 假设旋转数组没有重复的数字，旋转数组定义如下：
 * 0 1 4 5 6 7might become4 5 6 7 0 1 . 
 * 注：旋转数组实际上是两个有序序列，关键是找到边界
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
	    if(A == null || A.length <= 0)
	    	return -1;
	    return binarySearch(A, target, 0, A.length - 1);
	}
	
	//二分查找算法复杂度：O(logn)
	public int binarySearch(int[] A, int target, int start, int end) {
		if(start > end)
			return -1;
		int middle = (start + end) / 2;
		if(A[middle] == target) {
			return middle;
		}
		if(A[start] < A[middle]) { //可以判定左半边有序
			if(target >= A[start] && target < A[middle]) { //在左半边
				end = middle - 1;
			}
			else { //不在左半边
				start = middle + 1;
			}
		}
		else if(A[start] > A[middle]){ //可以判定右半边有序
			if(target > A[middle] && target <= A[end]) { //在右半边
				start = middle + 1;
			}
			else { //不在右半边
				end = middle - 1;
			}
		}
		else { //start和middle重合，但是又不是target，所以target一定在start右侧
			start ++;
		}
		return binarySearch(A, target, start, end);
	}
	
	public static void main(String[] args) {
		int[] A = {3,1};
		System.out.println(new SearchInRotatedSortedArray().search(A, 1));
	}
}
