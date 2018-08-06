package com.Array;
/*
 * ����һ��δ��������(����Ԫ�صķ�Χ��1-n)������ȱʧ���Ǹ����������������������
 * �㷨Ҫ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
 * Given[1,2,0]  return 3,
   and[3,4,-1,1] return 2. 
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		int len = A.length;
		for(int i = 0;i < len;i ++) {
			//��Ԫ��A[i]�ص�����Ӧ�ö�Ӧ��λ��A[i] - 1,����Ԫ��3���ڵ�λ��Ӧ����2
			while(A[i] > 0 && A[i] <= len && A[A[i] - 1] != A[i]) {
				int temp = A[A[i] - 1];  //����˳���ܵߵ�
				A[A[i] - 1] = A[i];
				A[i] = temp;
			}
		}
		//����һ�����飬�ҳ���Ӧ���ϵ��Ǹ�Ԫ��
		for(int i = 0;i < len;i ++) {
			if(A[i] != i + 1)
				return i + 1;
		}
		return len + 1;  //��ȱʧ�ͷ�����һ����
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3};
		System.out.println(new FirstMissingPositive().firstMissingPositive(A));
	}
}
