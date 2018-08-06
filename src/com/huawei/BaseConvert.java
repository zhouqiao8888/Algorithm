package com.huawei;

import java.util.Scanner;

public class BaseConvert {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			String str = s.next();
			System.out.println(Integer.valueOf(str.substring(2), 16));
		}
	}
}
