package com.qunaer;

import java.util.Scanner;

/*
 * ����һ�����֣���ȡ���ڴ����ֵ���һ������X�� Ҫ�� XΪ�Գ�����
 */
public class SymmetricNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(true) {
			if(isSymmetricNumber(++ n)) {
				System.out.println(n);
				break;
			}
		}
	}
	
	public static boolean isSymmetricNumber(int n) {
		String str = String.valueOf(n);
		int i = 0;
		int j = str.length() - 1;
		for(;i < str.length() / 2;i ++) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			else {
				j --;
			}
		}
		return true;
	}
}
