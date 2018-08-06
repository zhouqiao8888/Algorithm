package com.Array;
//��n��¥�ݣ�ÿ�ο�����1�㣬Ҳ������2�㣬���ܹ��ж����ַ�ʽ������������
public class ClimbingStairs {
	public int climbStairs(int n) {
        if(n <= 2)
        	return n;
        int f1 = 1;
        int f2 = 2;
        int res = 0;
        for(int i = 3;i <= n;i ++) {
        	res = f1 + f2;
        	f1 = f2;
        	f2 = res;
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(4));
	}
}
