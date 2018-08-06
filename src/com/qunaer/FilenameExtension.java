package com.qunaer;

import java.util.Scanner;

public class FilenameExtension {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int index = str.lastIndexOf('.');	//文件名里也可能包含.，所以要取最后一个.的位置
		System.out.println(str.substring(index + 1));
	}
}
