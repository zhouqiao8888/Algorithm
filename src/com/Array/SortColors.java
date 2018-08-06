package com.Array;
/*
 * ��ԭɫ����һ�����������0,1,2��������,
 * ͨ������ʹ��0ȫ��λ������ǰ�棬1ȫ��λ�������м䣬2ȫ��λ���������
 * 001112222
 * ע����Ҫ���м�ָ��
 */
public class SortColors {
	public void sortColors(int[] A) {
		int start = 0; //ָ��0Ԫ��
		int middle = 0; //ָ��1Ԫ��
		int end = A.length - 1; //ָ��2Ԫ��
		while(start <= middle && middle <= end) {
			if(A[middle] == 1)
				middle ++;
			else if(A[middle] == 0) {
				swap(A, start, middle);
				start ++;
				middle ++;
			}
			else {
				swap(A, middle, end);
				end --;
			}
		}
	}
	
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,2,2,1,0,0,2,1};
		new SortColors().sortColors(A);
		for(int i = 0;i < A.length;i ++) {
			System.out.print(A[i] + " ");
		}
	}
}
