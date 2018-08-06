package com.Array;
/*
 * 给定一个只包含0和1的2D矩阵,判断全部由1围成的正方形的最大面积,例如：
 * 1 0 1 0 0
   1 0 1 1 1
   1 1 1 1 1
   1 0 0 1 0
 返回4。
 思路： 动态规划：当我们判断以某个点为正方形右下角时最大的正方形时，
 那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
 否则该点为右下角的正方形最大就是它自己了。
 该点为右下角的正方形的最大边长，最多比它的上方，左方和左上方为右下角的正方形的边长多1，
 最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。  
 但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
 这时候只能取那三个正方形中最小的正方形的边长加1了。
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int res = 0; //边长
		for(int i = 0;i < m;i ++) {
			if(matrix[i][0] == '1') {
				dp[i][0] = 1;
				res = 1;
			}
		}
		
		for(int i = 0;i < n;i ++) {
			if(matrix[0][i] == '1') {
				dp[0][i] = 1;
				res = 1;
			}
		}
		
		for(int i = 1;i < m;i ++) {
			for(int j = 1;j < n;j ++) {
				if(matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					res = Math.max(dp[i][j], res);
				}
			}
		}
		return res * res;
	}
	
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, 
				{'1','1','1','1','1'}, {'1','0','1','1','1'}
		};
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}
}
