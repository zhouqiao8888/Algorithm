package com.String;
/*
 * ���������ַ�����count-say����:1, 11, 21, 1211, 111221, ... ���磺
 * 11 is read of as"two 1"or 21.
 * 21 is read off as"one 2, then one 1"or 1211
 */
public class CountAndSay {
	public String countAndSay(int n) {
		if(n <= 0)
			return new String();
		String res = "1";
		for(int i = 1;i < n;i ++) {
			res = appendStr(res);
		}
		return res;
    }
	
	public String appendStr(String str) {
		int c = str.charAt(0);
		int num = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i < str.length();i ++) {
			if(str.charAt(i) == c) {
				num ++;
				continue;
			}
			sb.append(num + "" + (char)c); //���ȵ�ʱ���׷�ӣ������ñ���
			num = 1;
			c = str.charAt(i);
		}
		sb.append(num + "" + (char)c);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(5));
	}
}
