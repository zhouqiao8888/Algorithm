package com.Array;
/*
 * ɾ�������������ظ���Ԫ�أ�ֻ�����������������������Ĵ洢�ռ䣬������ɾ��������鳤��
 * ����A =[1,1,1,2,2,3], -> A =[1,1,2,2,3]
 */
public class RemoveDuplicatesFromSortedArrayII {
	//��ʱ
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		if(A.length == 1)
			return 1;
		if(A.length == 2)
			return 2;
		int index = 0; //ָ���һ�����Ԫ�ص�λ�ã�֮���������ȣ�ָ���1
		for(int i = 1;i < A.length;) {
			if(i == A.length - 1 && A[i] == A[i - 1] && A[i] == A[i - 2]) {
				A[index ++] = A[i];
				break;
			}
			else {
				if(A[i] == A[i - 1] && A[i] == A[i + 1]) {
					if(index == 0) {
						index = i + 1;
					}
					if(i == A.length - 2) {
						i ++;
					}
					else {
						i = i + 2;
					}
				}
				else if(index != 0) {
					A[index ++] = A[i];
					i ++;
				}
			}
		}
		return index == 0 ? A.length : index;
	}
	
	//����չ��ǿ�������ظ������ָ����޸�indexȡֵ
	public int removeDuplicates2(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		if(A.length == 1)
			return 1;
		if(A.length == 2)
			return 2;
		int index = 2;
		for(int i = 2;i < A.length;i ++) {
			if(A[i] != A[index - 2]) {
				A[index ++] = A[i];
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,1,2,2,2};
		System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates2(A));
		for(int i = 0;i < A.length;i ++) {
			System.out.print(A[i] + " ");
		}
	}
}
