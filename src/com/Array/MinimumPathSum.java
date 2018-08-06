package com.Array;
/*
 * ����һ��m*n�Ǹ����飬Ѱ��һ�������ϵ����µ�·����ʹ��·���ϵ�Ԫ�غ���С
 * ע�������е���һ��ֻ�����»���������
 * ��̬�滮�ɽ�
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length <= 0 || grid[0].length <= 0) {
			return 0;
		}		
		int rows = grid.length;
		int cols = grid[0].length;
	    int[][] dp = new int[rows][cols]; //dp[i][j]��ʾ��i�е�j�еĵ�����Ӧ����С·����
		//��ʼ����1��
		dp[0][0] = grid[0][0];
		for(int i = 1;i < rows;i ++) { 
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		
		//��ʼ����1��
		for(int i = 1;i < cols;i ++) { 
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		
		for(int i = 1;i < rows;i ++) { 
			for(int j = 1;j < cols;j ++) {  //��ǰ��С·����ֻ������һ�������»��������ƶ������ģ�Ȼ���ټ��ϵ�ǰ���ֵ
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
