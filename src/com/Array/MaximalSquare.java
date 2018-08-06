package com.Array;
/*
 * ����һ��ֻ����0��1��2D����,�ж�ȫ����1Χ�ɵ������ε�������,���磺
 * 1 0 1 0 0
   1 0 1 1 1
   1 1 1 1 1
   1 0 0 1 0
 ����4��
 ˼·�� ��̬�滮���������ж���ĳ����Ϊ���������½�ʱ����������ʱ��
 �������Ϸ����󷽺����Ϸ�������Ҳһ����ĳ�������ε����½ǣ�
 ����õ�Ϊ���½ǵ����������������Լ��ˡ�
 �õ�Ϊ���½ǵ������ε����߳������������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εı߳���1��
 ��õ�������������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εĴ�С��һ���ģ��������ϸõ�Ϳ��Թ���һ������������Ρ�  
 ����������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εĴ�С��һ�����������ͻ�ȱ��ĳ�����䣬
 ��ʱ��ֻ��ȡ����������������С�������εı߳���1�ˡ�
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int res = 0; //�߳�
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
