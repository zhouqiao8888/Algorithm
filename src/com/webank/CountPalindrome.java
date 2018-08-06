package com.webank;
/*
 *给定一个数n,若一个数满足要求：小于n，且二进制形式是回文串，
 *统计这样的数的个数
 */
import java.util.Scanner;
public class CountPalindrome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			Long n = s.nextLong();
			long count = 0;
			for(int i = 0;i < n;i ++) {
				if(i != 0 && i % 2 == 0) {	//偶数的二进制形式肯定不是回文串
					continue;
				}
				String str = Integer.toBinaryString(i);
				if(isMatch(str)) {
					count ++;
					System.out.println(i + " " + str + " ");
				}
			}
			System.out.println(count);
		}		
	}	
	//判断是否是回文串
	public static boolean isMatch(String str) {
		int i = 0;
		int j = str.length() - 1;
		for(;i < str.length() / 2;i ++) {
			if(str.charAt(i) == str.charAt(j)) {
				j --;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
}

