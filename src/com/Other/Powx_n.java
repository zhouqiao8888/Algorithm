package com.Other;
//求x的n次方，不使用内置函数
public class Powx_n {
	public double pow(double x, int n) {
		if(n == 0)
			return 1;
		int exp = Math.abs(n);
		double res = 0;
		double temp = pow(x, exp / 2);
		res = temp * temp;
		if(exp % 2 != 0) {
			res = res * x;
		}
		return n > 0 ? res : 1 / res; 
    }
	
	public static void main(String[] args) {
		System.out.println(new Powx_n().pow(2, 7));
	}
}
