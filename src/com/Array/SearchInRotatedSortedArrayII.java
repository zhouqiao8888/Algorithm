package com.Array;
/*
 * ��һ����ת���������в���ĳ�����������±꣬���û�У�����-1
 * ������ת���������ظ������֣���ת���鶨�����£�
 * 0 1 4 4 5 6 7might become4 4 5 6 7 0 1 . 
 * ע����ת����ʵ�����������������У��ؼ����ҵ��߽�
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
	    if(A == null || A.length <= 0)
	    	return false;
	    int start = 0;
	    int end = A.length - 1;
	    return binarySearch(A, target, start, end);
	}
	
	//���ֲ����㷨���Ӷȣ�O(logn)
	public boolean binarySearch(int[] A, int target, int start, int end) {
		while(start <= end) {
			int middle = (start + end) / 2;
			if(A[middle] == target) {
				return true;
			}
			if(A[start] < A[middle]) { //�����ж���������
				if(target >= A[start] && target < A[middle]) { //������
					end = middle - 1;
				}
				else { //��������
					start = middle + 1;
				}
			}
			else if(A[start] > A[middle]) { //�����ж��Ұ������
				if(target > A[middle] && target <= A[end]) { //���Ұ��
					start = middle + 1;
				}
				else { //�����Ұ��
					end = middle - 1;
				}
			}
			else {
				start ++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,1,1,1};
		System.out.println(new SearchInRotatedSortedArrayII().search(A, 1));
	}
}
