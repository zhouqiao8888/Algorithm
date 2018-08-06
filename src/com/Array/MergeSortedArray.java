package com.Array;
//�ں�������������A��B,A��B��ʼ��Ԫ�ظ���Ϊm��n,����A���㹻����������B�е�Ԫ��(˵��A����Ŀռ��������û��ʹ��)
public class MergeSortedArray {
	//����Ҫ���������ռ�ⷨ���Ӻ���ǰ����
	public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0) {
        	if(A[i] > B[j]) {
        		A[k --] = A[i --]; 
        	}
        	else {
        		A[k --] = B[j --];
        	}
        }
        while(j >= 0) {
        	A[k --] = B[j --];
        }
    }
	
	public static void main(String[] args) {
		int A[] = new int[20];
		A[0] = 1;
		A[1] = 8;
		A[2] = 9;
		int B[] = {4,5,6};
		MergeSortedArray ms = new MergeSortedArray();
		ms.merge(A, 6, B, 3);
		for(int i : A) {
			System.out.print(i + " ");
		}
	}
}
