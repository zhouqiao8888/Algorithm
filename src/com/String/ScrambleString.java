package com.String;
/*
 * 判断一个小写字母字符串是否是另一个小写字母字符串的对称字符串
 *  great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
称rgeat是great的对称字符串
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if(s1.equals(s2))
			return true;
		//统计两个字符串对应字母个数是否相同
		int[] count = new int[26];
		for(int i = 0;i < s1.length();i ++) {
			count[s1.charAt(i) - 'a'] ++;
			count[s2.charAt(i) - 'a'] --;
		}
		
		for(int i = 0;i < count.length;i ++) {
			if(count[i] != 0) {
				return false;
			}
		}
		
		for(int i = 1;i < s1.length();i ++) {
			if(isScramble(s1.substring(0, i), s2.substring(0, i)) //没有交换
			&& isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			}
			if(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) //左右交换了
			&& isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
				return true;
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "gaert";
		System.out.println(new ScrambleString().isScramble(s1, s2));
	}
}
