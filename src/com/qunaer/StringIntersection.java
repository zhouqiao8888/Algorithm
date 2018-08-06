package com.qunaer;

import java.util.*;

/*
 * 给定两个均由大写英文字母组成的字符串（A-Z），检查这两个字符串是否仅包含相同的字母
 */
public class StringIntersection {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		if(str == null)
			return;
		String[] strArray = str.split(" ");
		String str1 = strArray[0];
		String str2 = strArray[1];
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		for(int i = 0;i < str1.length();i ++) {
			set1.add(str1.charAt(i));
		}
		
		for(int i = 0;i < str2.length();i ++) {
			set2.add(str2.charAt(i));
		}
		
		if(set1.equals(set2)) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
//		boolean flag = true;
//		if(set1.size() != set2.size()) {
//			System.out.println(false);
//		}
//		else {			
//			Iterator<Character> i1 = set1.iterator();
//			while(i1.hasNext()) {
//				char c = i1.next();
//				if(!set2.contains(c)) {
//					flag = false;
//					break;
//				}
//			}
//			System.out.println(flag);
//		}
	}
}
