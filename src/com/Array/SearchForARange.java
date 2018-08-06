package com.Array;
/*找出元素在有序数组中第一次和最后一次出现的位置，若该元素不存在，返回[-1,-1]
给定[5, 7, 7, 8, 8, 10] 8, 返回[3,4]
2,返回[-1,-1]
要求算法复杂度O(logn),可采用二分法
*/
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] res = {-1,-1};
        if(A == null || A.length <= 0)
        	return res;
        res[0] = findFirstAppearPosition(A, target, 0, A.length - 1);
        res[1] = findLastAppearPosition(A, target, 0, A.length - 1);
        return res;
    }
	
	//查找元素第一次出现的位置
	public int findFirstAppearPosition(int[] A, int target, int start, int end) {
		if(start > end)
			return -1;	
		int middle = (start + end) / 2;
		if(A[middle] == target) {
			if(middle == 0 || middle > 0 && A[middle - 1] != target) {
				return middle;
			}
			else { //这个数是target，前面的数也是target，这个数不是第一次出现
				end = middle - 1;
			}
		}
		else if(A[middle] > target) {
			end = middle - 1;
		}
		else {
			start = middle + 1;
		}
		return findFirstAppearPosition(A, target, start, end);	
	}
	
	//查找元素最后一次出现的位置
	public int findLastAppearPosition(int[] A, int target, int start, int end) {
		if(start > end) 
			return -1;
		int middle = (start + end) / 2;
		if(A[middle] == target) { //这个数是target，后面的数也是target，这个数不是最后一次出现
			if(middle == A.length - 1 || middle < A.length - 1 && A[middle + 1] != target) {
				return middle;
			}
			else { //这个数是target，后面的数也是target，这个数不是最后一次出现
				start = middle + 1;
			}
		}
		else if(A[middle] > target) {
			end = middle - 1;
		}
		else {
			start = middle + 1;
		}
		return findLastAppearPosition(A, target, start, end);
	}
	
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
		int[] res = new SearchForARange().searchRange(A, 7);
		for(int i = 0;i < res.length;i ++) {
			System.out.println(res[i]);
		}
	}
}
