package com.huawei;
/*
 * ����һ������ĸ�������Լ��ո���ɵ��ַ�������һ���ַ���
 * ��������ַ����к��и��ַ��ĸ���(�����ִ�Сд)��
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
