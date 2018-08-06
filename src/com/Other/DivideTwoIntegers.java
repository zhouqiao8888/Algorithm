package com.Other;
/*
 * 实现两个数的除法运算，不能使用乘、除、模运算
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if(dividend == 0 || divisor == 0)
			return 0;
		long a = abs(dividend); //被除数
		long b = abs(divisor);	//除数
		boolean flag = (dividend > 0) ^ (divisor > 0); //flag为true，说明一正一负，flag为false，说明两正或两负
		int res = 0;
		while(b <= a) {
			int count = 1;
			long temp = b;
			while(temp + temp <= a) {
				temp += temp;  //除数翻倍
				count += count; //计数翻倍
			}
			a -= temp;
			res += count;
		}
		return flag ? -res : res;
	}
	
	public long abs(int x) {
		if(x < 0)
			return -(long)x;  //换成(long)-x会超时
		return (long)x;
	}

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-128, -8));
	}
}
