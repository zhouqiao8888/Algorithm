package com.Array;
/*
 * ����һ�����飬����һ����״ͼ����Ϊ1����Ϊ����Ԫ�ش�С���ʸ���״ͼ����ס��ˮ������
 * Given[0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 */
public class TrappingRainWater {
	//����һ��
	public int trap(int[] A) {
		if(A.length <= 0) {
			return 0;
		}
		int leftMax = A[0];	//������߶�
		int rightMax = A[A.length - 1];	//�ұ����߶�
		int i = 0;   //����α�
		int j = A.length - 1;	//�ұ��α�
		int max = 0;
		while(i < j) {
			if(A[i] < A[j]) {
				max += Math.max(0, leftMax - A[i]);
				leftMax = Math.max(leftMax, A[i]);
				i ++;
			}
			else {
				max += Math.max(0, rightMax - A[j]);
				rightMax = Math.max(rightMax, A[j]);
				j --;
			}
		}
		return max;
	}
	
	//��������
	public int trap2(int[] A) {
		if(A.length <= 0) {
			return 0;
		}
		//Ѱ�����ֵ�±�
		int maxIndex = 0;
		for(int i = 0;i < A.length;i ++) {
			if(A[i] > A[maxIndex]) {
				maxIndex = i;
			}
		}
		int max = 0;
		//���������
		int leftMax = A[0];
		for(int i = 0;i < maxIndex;i ++) {
			if(leftMax > A[i]) {
				max += leftMax - A[i];
			}
			else {
			    leftMax = A[i];
			}
		}
		//���ұ�����
		int rightMax = A[A.length - 1];
		for(int i = A.length - 1;i > maxIndex;i --) {
			if(rightMax > A[i]) {
				max += rightMax - A[i];
			}
			else {
				rightMax = A[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(A));
	}
}
