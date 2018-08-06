package com.Array;

import java.util.Stack;

/*
 *����һ������Ϊn�����飬����Ԫ��Ϊ��״ͼ�ĸ߶ȣ����Ĭ��Ϊ1������״ͼ����Χ�ɵ����������
 */
public class LargestRectangleInHistogram {
	//�����������㷨���Ӷ�O(n^2)
	public int largestRectangleArea(int[] height) {
		if(height.length <= 0)
			return 0;
		int max = 0;
		for(int i = 0;i < height.length;i ++) {
			int width = 0;
			int minHight = height[i];
			for(int j = i;j < height.length;j ++) {
				width ++;
				minHight = Math.min(minHight, height[j]);  //Ϊ���ܹ��ɾ��Σ�ȡ��С�ĸ߶�
				int tempMax = minHight * width;
				max = Math.max(max, tempMax);
			}
		}
		return max;
	}
	
	/*��ջ����һ����������{1,1,2,2,2,3}�������ֵ�ǰ����Ԫ�ر�ջ��Ԫ��С��
	 *��һֱ����ջ��Ԫ�أ�ֱ����ǰ����Ԫ�ش��ڵ���ջ��Ԫ�أ����ҵ����Ĺ����м�¼�ɹ��ɵľ���������ֵ
	 *�㷨���Ӷ�O(n)
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
		int[] height = {2,1,5,6,2,3};
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea2(height));
	}
}
