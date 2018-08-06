package com.Array;
/*
 * ����һ�����飬�����е�ÿ��Ԫ�ش��������Ծ���������
 * һ��������λ���������㣬�ж����ܷ���Ծ��������յ�
 * A =[2,3,1,1,4], return true. 
   A =[3,2,1,0,4], return false. 
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if(A == null || A.length <= 0)
			return false;
		int max = 0; //������Ծ��������±�
		for(int i = 0;i < A.length && i <= max;i ++) {
			max = Math.max(max, i + A[i]);
		}
		System.out.println("max:" + max);
		return max >= A.length - 1 ? true : false;
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,1,0,4};
		System.out.println(new JumpGame().canJump(A));
	}
}
