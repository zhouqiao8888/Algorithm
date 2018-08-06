package com.Array;

import java.util.Stack;

/*
 *给定一个长度为n的数组，数组元素为柱状图的高度，宽度默认为1，求柱状图可以围成的最大矩形面积
 */
public class LargestRectangleInHistogram {
	//暴力搜索：算法复杂度O(n^2)
	public int largestRectangleArea(int[] height) {
		if(height.length <= 0)
			return 0;
		int max = 0;
		for(int i = 0;i < height.length;i ++) {
			int width = 0;
			int minHight = height[i];
			for(int j = i;j < height.length;j ++) {
				width ++;
				minHight = Math.min(minHight, height[j]);  //为了能构成矩形，取最小的高度
				int tempMax = minHight * width;
				max = Math.max(max, tempMax);
			}
		}
		return max;
	}
	
	/*用栈构造一个上升序列{1,1,2,2,2,3}，若发现当前数组元素比栈顶元素小，
	 *则一直弹出栈顶元素，直到当前数组元素大于等于栈顶元素，并且弹出的过程中记录可构成的矩形面积最大值
	 *算法复杂度O(n)
	 */
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
		int[] height = {2,1,5,6,2,3};
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea2(height));
	}
}
