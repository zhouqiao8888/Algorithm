package com.Array;
//��һ������ƽ������������ϵͳ�Դ�����
public class Sqrtx {
	//ţ�ٷ����
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
