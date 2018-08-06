package com.Other;
/*
 * ʵ���������ĳ������㣬����ʹ�óˡ�����ģ����
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if(dividend == 0 || divisor == 0)
			return 0;
		long a = abs(dividend); //������
		long b = abs(divisor);	//����
		boolean flag = (dividend > 0) ^ (divisor > 0); //flagΪtrue��˵��һ��һ����flagΪfalse��˵������������
		int res = 0;
		while(b <= a) {
			int count = 1;
			long temp = b;
			while(temp + temp <= a) {
				temp += temp;  //��������
				count += count; //��������
			}
			a -= temp;
			res += count;
		}
		return flag ? -res : res;
	}
	
	public long abs(int x) {
		if(x < 0)
			return -(long)x;  //����(long)-x�ᳬʱ
		return (long)x;
	}

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-128, -8));
	}
}
