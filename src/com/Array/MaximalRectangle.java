package com.Array;

import java.util.Stack;

/*给定一个只包含0和1的2D矩阵,判断全部由1围成的矩形的最大面积,例如：
0 0 1 1 0 -> 0 0 1 1 0
0 0 1 1 0 -> 0 0 2 2 0
1 1 0 0 0 -> 1 1 0 0 0
1 1 1 0 0 -> 2 2 1 0 0
返回4。
思路：先把每一行转化为直方图，然后求出直方图围成的矩形的最大面积
要转化为直方图，方法是每一行的数值都累加上一行计算出来的数值，
而第一行的数值就是本身。如果原始矩阵中遇到0，则累加中断，重新置0。
*/
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			return 0;	
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int res = 0; 
		for(int i = 0;i < m;i ++) {
			for(int j = 0;j < n;j ++) {
				if(i == 0) { //第一行
					dp[i][j] = matrix[i][j] - '0';
				}
				else { //判断当前字符是否为0
					if(matrix[i][j] == '0') {
						dp[i][j] = 0;
					}
					else {
						dp[i][j] = dp[i - 1][j] + 1;
					}
				}
			}
		}
		
//		//打印测试
//		for(int i = 0;i < m;i ++) {
//			for(int j = 0;j < n;j ++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//将每一行当做直方图看待
		for(int i = 0;i < m;i ++) {
			int[] height = new int[n];
			for(int j = 0;j < n;j ++) {
				height[j] = dp[i][j];
			}
			res = Math.max(res, largestRectangleArea2(height));
		}
		return res;
	}
	
	public int largestRectangleArea2(int[] height) {
		if(height.length <= 0)
			return 0;
		Stack<Integer> s = new Stack<Integer>();
		int max = 0;
		for(int i = 0;i < height.length;i ++) {
			if(s.isEmpty() || height[i] >= s.peek()) {
				s.push(height[i]);
			}
			else {
				int width = 0;
				while(!s.isEmpty() && height[i] < s.peek()) { //直到当前数组元素大于等于栈顶元素，才结束循环
					width ++;
					max = Math.max(max, width * s.peek());
					s.pop();
				}
				while(width != 0) { //弹出多少个栈顶元素，就补多少个当前数组元素
					s.push(height[i]);
					width --;
				}
				s.push(height[i]);
			}
		}
		//System.out.println(s);
		int width = 0;
		while(!s.isEmpty()) {
			width ++;
			max = Math.max(max, width * s.peek());
			s.pop();
		}
		return max;
	}
	
	public static void main(String[] args) {
		char[][] matrix = {{'0','0','1','1','0'}, {'0','0','1','1','0'}, 
				{'1','1','0','0','0'}, {'1','1','1','0', '0'}
		};
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));	
	}
	
	
}
