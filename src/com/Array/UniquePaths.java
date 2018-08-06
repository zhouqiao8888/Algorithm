package com.Array;
/*
 * 有一个m*n的网格，一个机器人位于网格的左上角，该机器人想要到达网格的右下角，问有多少条不同的路径
 * 该机器人在某一点只能向下或者向右走
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if(m <= 0 || n <= 0)
			return 0;
		int[][] dp = new int[m][n];

		//初始化第1列
		for(int i = 0;i < m;i ++) { 
			dp[i][0] = 1;
		}
		
		//初始化第1行
		for(int i = 0;i < n;i ++) { 
			dp[0][i] = 1;
		}
		
		for(int i = 1;i < m;i ++) { 
			for(int j = 1;j < n;j ++) {  //当前点只能是上一个点向下或者向右移动而来的，所以可能的路径是两种情况之和
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(7, 3));
	}
}
