package com.qunaer;

import java.util.Scanner;

public class FilenameExtension {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int index = str.lastIndexOf('.');	//�ļ�����Ҳ���ܰ���.������Ҫȡ���һ��.��λ��
		System.out.println(str.substring(index + 1));
	}
}
