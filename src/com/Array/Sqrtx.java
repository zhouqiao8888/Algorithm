package com.Array;
//求一个数的平方根，不能用系统自带函数
public class Sqrtx {
	//牛顿法求解
	public int sqrt(int x) {
		if(x == 0)
			return 0;
		long r = x;
		while(r * r > x) {
			r = (r + x / r) / 2;
		}
		return (int)r;
    }
	
	public static void main(String[] args) {
		System.out.println(new Sqrtx().sqrt(16));
	}
}
