package com.huawei;
import java.util.Scanner;
/*
 * �����ַ������һ�����ʵĳ��ȣ������Կո������ 
 * ����һ���ַ���
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
