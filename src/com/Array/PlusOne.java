package com.Array;
/*
 * ĳ�����ĸ���λ������������������1�������������ʽ����
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length <= 0)
			return digits;
		int add = 1; //��λ
		for(int i = digits.length - 1;i >= 0;i --) {
			int temp = (digits[i] + add) % 10;
			add = (digits[i] + add) / 10;
			digits[i] = temp;
		}
		//System.out.println(add);
		if(add == 1) { //�������Դ��ڽ�λ��˵��������9999 + 1 = 10000�������
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
		else {
			return digits;
		}
	}
	
	public static void main(String[] args) {
		int[] digits = {9,8};
		int[] res = new PlusOne().plusOne(digits);
		for(int i = 0;i < res.length;i ++) {
			System.out.print(res[i] + " ");
		}
	}
}
