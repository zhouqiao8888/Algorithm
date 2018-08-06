package com.huawei;

import java.util.Scanner;

public class Approximate {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		float f = s.nextFloat();
		float f1 = f;
		System.out.println(Math.round(f));	//ceil向上，floor向下，round标准四舍五入
		int i = (int)f1;	//先取整数部分
		System.out.println(f1 - i >= 0.5 ? i + 1 : i);
		
	}
}
