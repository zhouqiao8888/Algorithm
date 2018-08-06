package com.Array;
/*�ҳ�Ԫ�������������е�һ�κ����һ�γ��ֵ�λ�ã�����Ԫ�ز����ڣ�����[-1,-1]
����[5, 7, 7, 8, 8, 10] 8, ����[3,4]
2,����[-1,-1]
Ҫ���㷨���Ӷ�O(logn),�ɲ��ö��ַ�
*/
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] res = {-1,-1};
        if(A == null || A.length <= 0)
        	return res;
        res[0] = findFirstAppearPosition(A, target, 0, A.length - 1);
        res[1] = findLastAppearPosition(A, target, 0, A.length - 1);
        return res;
    }
	
	//����Ԫ�ص�һ�γ��ֵ�λ��
	public int findFirstAppearPosition(int[] A, int target, int start, int end) {
		if(start > end)
			return -1;	
		int middle = (start + end) / 2;
		if(A[middle] == target) {
			if(middle == 0 || middle > 0 && A[middle - 1] != target) {
				return middle;
			}
			else { //�������target��ǰ�����Ҳ��target����������ǵ�һ�γ���
				end = middle - 1;
			}
		}
		else if(A[middle] > target) {
			end = middle - 1;
		}
		else {
			start = middle + 1;
		}
		return findFirstAppearPosition(A, target, start, end);	
	}
	
	//����Ԫ�����һ�γ��ֵ�λ��
	public int findLastAppearPosition(int[] A, int target, int start, int end) {
		if(start > end) 
			return -1;
		int middle = (start + end) / 2;
		if(A[middle] == target) { //�������target���������Ҳ��target��������������һ�γ���
			if(middle == A.length - 1 || middle < A.length - 1 && A[middle + 1] != target) {
				return middle;
			}
			else { //�������target���������Ҳ��target��������������һ�γ���
				start = middle + 1;
			}
		}
		else if(A[middle] > target) {
			end = middle - 1;
		}
		else {
			start = middle + 1;
		}
		return findLastAppearPosition(A, target, start, end);
	}
	
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
		int[] res = new SearchForARange().searchRange(A, 7);
		for(int i = 0;i < res.length;i ++) {
			System.out.println(res[i]);
		}
	}
}
