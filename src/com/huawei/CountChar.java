package com.huawei;
/*
 * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 * 输出输入字符串中含有该字符的个数(不区分大小写)。
 */
import java.util.Scanner;
public class CountChar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next().toUpperCase();
		char c = s.next().toUpperCase().charAt(0);
		int count = 0;
		for(int i = 0;i < str.length();i ++) {
			if(str.charAt(i) == c) {
				count ++;
			}
		}
		System.out.println(count);
	}
}
