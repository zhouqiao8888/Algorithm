package com.Array;

import java.util.Stack;

/*����һ��ֻ����0��1��2D����,�ж�ȫ����1Χ�ɵľ��ε�������,���磺
0 0 1 1 0 -> 0 0 1 1 0
0 0 1 1 0 -> 0 0 2 2 0
1 1 0 0 0 -> 1 1 0 0 0
1 1 1 0 0 -> 2 2 1 0 0
����4��
˼·���Ȱ�ÿһ��ת��Ϊֱ��ͼ��Ȼ�����ֱ��ͼΧ�ɵľ��ε�������
Ҫת��Ϊֱ��ͼ��������ÿһ�е���ֵ���ۼ���һ�м����������ֵ��
����һ�е���ֵ���Ǳ������ԭʼ����������0�����ۼ��жϣ�������0��
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
				if(i == 0) { //��һ��
					dp[i][j] = matrix[i][j] - '0';
				}
				else { //�жϵ�ǰ�ַ��Ƿ�Ϊ0
					if(matrix[i][j] == '0') {
						dp[i][j] = 0;
					}
					else {
						dp[i][j] = dp[i - 1][j] + 1;
					}
				}
			}
		}
		
//		//��ӡ����
//		for(int i = 0;i < m;i ++) {
//			for(int j = 0;j < n;j ++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//��ÿһ�е���ֱ��ͼ����
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
				while(!s.isEmpty() && height[i] < s.peek()) { //ֱ����ǰ����Ԫ�ش��ڵ���ջ��Ԫ�أ��Ž���ѭ��
					width ++;
					max = Math.max(max, width * s.peek());
					s.pop();
				}
				while(width != 0) { //�������ٸ�ջ��Ԫ�أ��Ͳ����ٸ���ǰ����Ԫ��
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
