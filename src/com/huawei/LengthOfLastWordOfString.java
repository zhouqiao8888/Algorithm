package com.huawei;
import java.util.Scanner;
/*
 * 计算字符串最后一个单词的长度，单词以空格隔开。 
 * 输入一行字符串
 */
public class LengthOfLastWordOfString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine().trim();
		String[] strArray = str.split(" ");
//		for(String ss : strArray) {
//			System.out.println(ss);
//		}
		
		System.out.println(strArray[strArray.length - 1].length());
	}
}
