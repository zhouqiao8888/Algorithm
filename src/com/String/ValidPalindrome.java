package com.String;
//����һ���ַ�����ֻͳ�����е���ĸ�����֣��ж��Ƿ�Ϊ���Ĵ����ж�ʱ�����ִ�Сд�����մ�Ĭ��Ϊ���Ĵ�
//����"A man, a plan, a canal: Panama"�ǻ��Ĵ���"race a car"���ǻ��Ĵ�.
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
