package com.lianjia;
import java.util.*;
/*
 * n根木棍，第i根木棍长度是i,请问最少去除几根木棍可以使剩下的木棍不能构成一个三角形。
 * 思路：考虑两边之和大于第三边，可以构成三角形的情况，即需要被去除的情况；
 * 或者，因为保留的是小于等于n的斐波那契数列(不能构成三角形的1,2,3,5,8),
 * 可以先求出所有小于等于n的斐波那契数列，然后用n-数列的长度，等于需要去除的木棍个数。
 */
public class StickProblem {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();
			int x1 = 2;
			int x2 = 3;
			int result = 0;
			for(int i = 4;i <= n;i ++) {
				if(i < x1 + x2) {	//两边之和大于第三边，可以构成三角形的情况，即去除木棍的情况
					result ++;
					//System.out.println("x1: "+x1+" x2: "+x2);
				}
				else {
					x1 = x2;
					x2 = i;
				}
			}
			System.out.println(result);
//			StickProblem sp = new StickProblem();
//			System.out.println(sp.getCount(n));
			x1 = 2;
			x2 = 3;
			result = 0;
		}		
	}
	
	public int getCount(int n) {	//保留的是小于等于n的斐波那契数列(不能构成三角形的)
		if(n == 1 || n == 2 || n == 3)
			return 0;
		int x1 = 2;
		int x2 = 3;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		while(x1 + x2 <= n) {
			int x = x1 + x2;
			list.add(x);
			x1 = x2;
			x2 = x;
		}
		//System.out.println(list);
		return n - list.size();
	}
}
