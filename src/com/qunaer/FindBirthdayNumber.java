package com.qunaer;

import java.util.Scanner;

/*
 * 给定任意身份证号(18位)，返回该身份证的出生日期信息，如果身份证格式不对，输出“ERROR”。
 * 第7—14位数字表示：出生年、月、日；
 */
public class FindBirthdayNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			String str = s.next();
			if(str.length() != 18) {
				System.out.println("ERROR");
			}
			else {
				System.out.println(str.substring(6, 14));
			}
		}
	}
}
