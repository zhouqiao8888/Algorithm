package com.Array;
/*
 * 顺时针旋转矩阵90度，不需要额外空间
 * 1 2 3                 1 4 7                7 4 1
 * 4 5 6  (主对角线反转)->  2 5 8  (中轴线反转)->   8 5 2
 * 7 8 9                 3 6 9	              9 3 6
 * 
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix.length <= 0 || matrix[0].length <= 0)
			return;
		int rows = matrix.length;
		int cols = matrix[0].length;
		//主对角线反转
		for(int i = 0;i < rows;i ++) {
			for(int j = 0;j < i;j ++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		//中轴线反转		
		for(int i = 0;i < rows;i ++) {
			for(int j = 0;j < cols / 2;j ++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][cols - 1 - j];
				matrix[i][cols - 1 - j] = temp;
			}
		}
	}
	
	//只是要求顺时针旋转90度打印，并不对原矩阵修改
	public void printMatrix(int[][] matrix) {
		if(matrix.length <= 0 || matrix[0].length <= 0)
			return;
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int j = 0;j < cols;j ++) {
			for(int i = rows - 1;i >= 0;i --) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		new RotateImage().printMatrix(matrix);
		System.out.println();
		new RotateImage().rotate(matrix);
		int rows = matrix.length;
		int cols = matrix[0].length;
		//主对角线反转
		for(int i = 0;i < rows;i ++) {
			for(int j = 0;j < cols;j ++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
