package com.zhaoshangbank;
/*
 * 给出一个非空字符串，判断这个字符串是否是由它的一个子串多次首尾拼接构成的。
 * 如果字符串满足上述条件，则输出最长的满足条件的子串；如果不满足条件，则输出false。
 * 例如：给定abcabc,则最长子串是abc
 * 思路：原串的长度一定是子串长度的整数倍，当满足这一条件后，
 * 判断str.charAt(i)是否等于str.charAt(i % sublen),i可从sublen开始遍历
 */
public class FindMaxLengthString {
	public String findSubString(String str) {
		int strlen = str.length();
		int sublen = str.length() - 1;
		while(sublen > 0) {
			boolean flag = true;
			if(strlen % sublen == 0) {
				for(int i = sublen;i < strlen;i ++) {
					if(str.charAt(i) != str.charAt(i % sublen)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					return str.substring(0, sublen);
				}
			}
			
			if(strlen % sublen != 0 || !flag) {	//子串长度不符合或者长度符合但是前后字符串不匹配
				sublen --;
			}		
		}
		return null;
	}
	
	public static void main(String[] args) {
		FindMaxLengthString fs = new FindMaxLengthString();
		System.out.println(fs.findSubString("cabcabcab"));
	}
}
