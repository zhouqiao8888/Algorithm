package com.huawei;

import java.util.Scanner;

public class Approximate {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		float f = s.nextFloat();
		float f1 = f;
		System.out.println(Math.round(f));	//ceil���ϣ�floor���£�round��׼��������
		int i = (int)f1;	//��ȡ��������
		System.out.println(f1 - i >= 0.5 ? i + 1 : i);
		
	}
}
