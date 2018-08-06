package com.huawei;

import java.util.*;

//输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
public class NotRepeatNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		String str = String.valueOf(num);
		List<Character> list = new ArrayList<Character>();
		for(int i = str.length() - 1;i >= 0;i --) {
			char c = str.charAt(i);
			if(!list.contains(c)) {
				list.add(c);
			}
			System.out.println(list);
		}
		StringBuffer sb = new StringBuffer();
		Iterator<Character> iterator = list.iterator();
 		while(iterator.hasNext()) {
 			char c = iterator.next();
 			sb.append(c);
 		}
 		System.out.println(sb);
	}
}
