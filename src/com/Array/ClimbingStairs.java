package com.Array;
//共n层楼梯，每次可以爬1层，也可以爬2层，问总共有多少种方式可以爬到顶层
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
