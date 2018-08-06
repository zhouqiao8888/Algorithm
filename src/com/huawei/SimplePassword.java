package com.huawei;

import java.util.Scanner;

public class SimplePassword {
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		while(s.hasNext()) {
			String str = s.next();
			StringBuffer sb = new StringBuffer(str);
			for(int i = 0;i < sb.length();i ++) {
				char c = sb.charAt(i);
				if(c >= 'A' && c <= 'Y') {
					char ct = (char)((c + "").toLowerCase().charAt(0) + 1);
					sb.setCharAt(i, ct);
				}
				else if(c == 'Z') {
					sb.setCharAt(i, 'a');
				}
				else if(c >= 'a' && c <= 'c') {
					sb.setCharAt(i, '2');
				}
				else if(c >= 'd' && c <= 'f') {
					sb.setCharAt(i, '3');
				}
				else if(c >= 'g' && c <= 'i') {
					sb.setCharAt(i, '4');
				}
				else if(c >= 'j' && c <= 'l') {
					sb.setCharAt(i, '5');
				}
				else if(c >= 'm' && c <= 'o') {
					sb.setCharAt(i, '6');
				}
				else if(c >= 'p' && c <= 's') {
					sb.setCharAt(i, '7');
				}
				else if(c >= 't' && c <= 'v') {
					sb.setCharAt(i, '8');
				}
				else if(c >= 'w' && c <= 'z') {
					sb.setCharAt(i, '9');
				}
				else {
					continue;
				}
			}
			System.out.println(sb.toString());
		}
	}
}
