package com.Array;
/*
 * ��һ��2D����������ĳһ�����Ƿ���ڣ��þ�����������Ҫ��
 * ÿһ�����������еģ���ÿһ�е�һ����Ҫ��ǰһ�����һ������
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
