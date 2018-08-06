package com.String;
//给定一个字符串，只统计其中的字母和数字，判断是否为回文串（判断时不区分大小写），空串默认为回文串
//例："A man, a plan, a canal: Panama"是回文串，"race a car"不是回文串.
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s == null)
        	return true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i ++) {
        	char c = s.charAt(i);
        	if((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
        		sb.append(c);
        	}
        }
        int j = sb.length() - 1;
        for(int i = 0;i < sb.length() / 2;i ++) {
        	int temp = Math.abs(sb.charAt(i) - sb.charAt(j));
        	if(temp != 0 && temp != 32) {
        		return false;
        	}
        	j --;
        }
        return true;
    }
	
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		System.out.println(vp.isPalindrome(s2));
	}
}
