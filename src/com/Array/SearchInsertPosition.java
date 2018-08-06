package com.Array;
/*找出元素在有序数组中的下标，若该元素不存在，返回它应该插入的位置
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0 
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		for(int i = 0;i < A.length;i ++) {
			if(A[i] >= target)
				return i;
		}
		return A.length;
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,5,6};
		System.out.println(new SearchInsertPosition().searchInsert(A, 2));
	}
}
