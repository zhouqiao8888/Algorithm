package com.Array;
/*
 * 给定一个数n，按照螺旋式产生一个二维矩阵（1-n^2），例如，给定n = 3
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if(n <= 0) {
			int[][] res = new int[0][];
			return res;
		}
		if(n == 1) {
			int[][] res = {{1}};
			return res;
		}
		int[][] res = new int[n][n];	
		getRes(res, 0, 0, n - 1, n - 1, 1);
		return res;
	}
	
	public void getRes(int[][] matrix, int i, int j, int i2, int j2, int count) {
		if(i > i2 || j > j2)
			return;
	
		for(int k = j;k <= j2;k ++) { //第一条边
			matrix[i][k] = count ++;
		}
		
		for(int k = i + 1;k <= i2;k ++) { //第二条边
			matrix[k][j2] = count ++;
		}
		
		for(int k = j2 - 1;k >= j;k --) { //第三条边
			matrix[i2][k] = count ++;
		}
		
		for(int k = i2 - 1;k >= i + 1;k --) { //第四条边
			matrix[k][j] = count ++;
		}
		getRes(matrix, i + 1, j + 1, i2 - 1, j2 - 1, count);
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] res = new SpiralMatrixII().generateMatrix(n);
		for(int i = 0;i < n;i ++) {
			for(int j = 0;j < n;j ++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
