package com.wuyao;
/*
 *输入一串字符，判断第二个字符串的字符是否都存在于第一个字符串，返回true，否则false，两个串中间有;号连接
     如输入：   
  ABCNB51;51NB     
    输出：true
 */
import java.util.*;
public class StringJudge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.next();
			String[] strArr = str.split(";");
			String s1 = strArr[0];
			String s2 = strArr[1];
			System.out.println("s1:" + s1 + " s2:" + s2);
			boolean flag = true;
			for(int i = 0;i < s2.length();i ++) {
				char c = s2.charAt(i);
				if(!s1.contains(c + "")) {
					flag = false;
					break;
				}
			}
			System.out.println(flag);
		}
	}
}
