package com.Array;
/*
 * 在一个2D矩阵中搜索某一个数是否存在，该矩阵满足如下要求：
 * 每一行是升序排列的，且每一行第一个数要比前一行最后一个数大
 *[1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]

 */
public class SearchA2dMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int col = 0;
		int row = matrix.length - 1;
		while(col < matrix[0].length && row >= 0) {
			if(matrix[row][col] > target)
				row --;
			else if(matrix[row][col] < target) {
				col ++;
			}
			else {
				return true;
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
		System.out.println(new SearchA2dMatrix().searchMatrix(matrix, 51));
	}
}
