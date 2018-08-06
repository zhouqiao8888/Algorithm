package com.Array;
/*
 * 有一个m*n的网格，一个机器人位于网格的左上角，该机器人想要到达网格的右下角，问有多少条不同的路径
 * 该机器人在某一点只能向下或者向右走，网格中有一些障碍(被标记为1)，例如：
 *[0,0,0],
  [0,1,0],
  [0,0,0]

 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
				
		//初始化第1列
		for(int i = 0;i < m;i ++) {
			if(obstacleGrid[i][0] == 0) {
				dp[i][0] = 1;
			}
			else {
				dp[i][0] = 0;
				break;
			}
		}
		
		//初始化第1行
		for(int i = 0;i < n;i ++) { 
			if(obstacleGrid[0][i] == 0) {
				dp[0][i] = 1;
			}
			else {
				dp[0][i] = 0;
				break;
			}			
		}
		
		for(int i = 1;i < m;i ++) { 
			for(int j = 1;j < n;j ++) {  
				if(obstacleGrid[i][j] == 1) {  //走不通
					dp[i][j] = 0;
				}
				else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 
				}
			}
		}
		return dp[m - 1][n - 1];     
	}
	
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
		int[][] obstacleGrid2 = {{1}};
		System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid2));
	}
	
}
