package com.Array;
/*
 * 给定一个m*n非负数组，寻找一条从左上到右下的路径，使得路径上的元素和最小
 * 注意数组中的任一点只能向下或者向右走
 * 动态规划可解
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length <= 0 || grid[0].length <= 0) {
			return 0;
		}		
		int rows = grid.length;
		int cols = grid[0].length;
	    int[][] dp = new int[rows][cols]; //dp[i][j]表示第i行第j列的点所对应的最小路径和
		//初始化第1列
		dp[0][0] = grid[0][0];
		for(int i = 1;i < rows;i ++) { 
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		
		//初始化第1行
		for(int i = 1;i < cols;i ++) { 
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		
		for(int i = 1;i < rows;i ++) { 
			for(int j = 1;j < cols;j ++) {  //当前最小路径和只能是上一个点向下或者向右移动而来的，然后再加上当前点的值
				dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
			}
		}
		return dp[rows - 1][cols - 1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] grid2 = {{1}};
		System.out.println(new MinimumPathSum().minPathSum(grid2));
	}
}
