package com.huawei;

import java.util.Scanner;

public class StringSplit {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] strArray = new String[2];
		strArray[0] = s.next();
		strArray[1] = s.next();
		for(String temp : strArray) {
			if(temp != null) {
				StringBuffer str = new StringBuffer(temp);
				if(str.length() < 8) {
					int zeros = 8 - str.length();
					str = addZeros(str, zeros);
					System.out.println(str.toString());
				}
				else if(str.length() == 8) {
					System.out.println(str.toString());
				}
				else {
					int n = str.length() / 8;
					int start = 0;	//����һ��ָ�벻�ϵ�����׷��8����
					for(int i = 0;i < n;i ++) {
						System.out.println(str.substring(start, start + 8));
						start += 8;
					}
					//System.out.println(start);
					//û�е�ͷ�Ͳ���
					if(start != str.length()) {
						StringBuffer restString = new StringBuffer(str.substring(start, str.length()));
						int zeros = 8 - restString.length();
						restString = addZeros(restString, zeros);
						System.out.println(restString.toString());
					}
				}
			}
		}
	}
	
	public static StringBuffer addZeros(StringBuffer str, int zeros) {
		for(int i = 0;i < zeros;i ++) {
			str.append('0');
		}
		return str;
	}
}
