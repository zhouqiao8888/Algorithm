package com.Array;
/*
 * ��һ����ת���������в���ĳ�����������±꣬���û�У�����-1
 * ������ת����û���ظ������֣���ת���鶨�����£�
 * 0 1 4 5 6 7might become4 5 6 7 0 1 . 
 * ע����ת����ʵ�����������������У��ؼ����ҵ��߽�
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
	    if(A == null || A.length <= 0)
	    	return -1;
	    return binarySearch(A, target, 0, A.length - 1);
	}
	
	//���ֲ����㷨���Ӷȣ�O(logn)
	public int binarySearch(int[] A, int target, int start, int end) {
		if(start > end)
			return -1;
		int middle = (start + end) / 2;
		if(A[middle] == target) {
			return middle;
		}
		if(A[start] < A[middle]) { //�����ж���������
			if(target >= A[start] && target < A[middle]) { //������
				end = middle - 1;
			}
			else { //��������
				start = middle + 1;
			}
		}
		else if(A[start] > A[middle]){ //�����ж��Ұ������
			if(target > A[middle] && target <= A[end]) { //���Ұ��
				start = middle + 1;
			}
			else { //�����Ұ��
				end = middle - 1;
			}
		}
		else { //start��middle�غϣ������ֲ���target������targetһ����start�Ҳ�
			start ++;
		}
		return binarySearch(A, target, start, end);
	}
	
	public static void main(String[] args) {
		int[] A = {3,1};
		System.out.println(new SearchInRotatedSortedArray().search(A, 1));
	}
}
