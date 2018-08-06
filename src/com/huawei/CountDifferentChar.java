package com.huawei;

import java.util.*;

public class CountDifferentChar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		Set<Character> set = new HashSet<Character>();
		for(int i = 0;i < str.length();i ++) {
			char c = str.charAt(i);
			if(c >= 0 && c <= 127) {
				set.add(c);
			}
		}
		System.out.println(set.size());
	}
}
