package com.huawei;

import java.util.Scanner;

public class InverseString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		String str = String.valueOf(i);
		System.out.println(new StringBuilder(str).reverse());	//StringBuilder有reverse方法，String没有
	}
}
