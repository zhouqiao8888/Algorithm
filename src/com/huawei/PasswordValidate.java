package com.huawei;

import java.util.Scanner;

public class PasswordValidate {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			String str = s.next();
			if(str.length() <= 8) {
				System.out.println("NG");
				continue;
			}
			int[] type = new int[4];
			for(int i = 0;i < str.length();i ++) {
				char c = str.charAt(i);
				if(c >= 'A' && c <= 'Z') {
					type[0] = 1;
					continue;
				}
				else if(c >= 'a' && c <= 'z') {
					type[1] = 1;
					continue;
				}
				else if(c >= '0' && c <= '9') {
					type[2] = 1;
					continue;
				}
				else {
					type[3] = 1;
					continue;
				}
			}
			
			int sum = 0;
			for(int i = 0;i < type.length;i ++) {
				sum += type[i];
			}
			if(sum < 3) {
				System.out.println("NG");
				continue;
			}
			else {
				if(isRepeat(str)) {
					System.out.println("NG");
				}
				else {
					System.out.println("OK");
				}
			}
		}
	}
	
	public static boolean isRepeat(String str) {//相同长度不超2，反例：至少为3
		int len = str.length();
		for(int i = 0;i < len - 3;i ++) {
			int j = i + 3;
			String substr = str.substring(i, j);
			String substr2 = str.substring(j + 1, len);
			if(substr2.contains(substr))
				return true;
		}
		return false;
	}
}
