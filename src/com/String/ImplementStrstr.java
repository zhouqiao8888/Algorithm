package com.String;
/*
 * 给定两个字符串1,2，找到字符串2在字符串1中首次出现的位置后，返回余下的字符串
 * KMP算法
 */
public class ImplementStrstr {
	public String strStr(String haystack, String needle) {
		if(haystack == null || needle == null || haystack.length() < needle.length())
			return null;
		int len1 = haystack.length();
		int len2 = needle.length();
		for(int i = 0;i <= len1 - len2;i ++) {
			int j = 0;
			for(;j < len2;j ++) {
				if(haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
			if(j == len2)
				return haystack.substring(i);
		}
		return null;
	}
	
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "a";
		System.out.println(new ImplementStrstr().strStr(s1, s2));
	}
}
