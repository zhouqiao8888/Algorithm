package com.String;
/*有如下映射关系：'A' -> 1，'B' -> 2，...，'Z' -> 26
 给出编码信息12，则它可以解码成"AB"(1 2) or"L"(12). 2种
 */
public class DecodeWays {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
        	return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= s.length();i ++) {
        	if(s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') { //若前一个字符不为1~9，则当前字符可以为任意数字
        		dp[i] += dp[i - 1];
        	}
        	if(s.charAt(i - 2) == '1' || //若往前推两个的字符为1，则前面一个字符可以为任意数；若为2，则前面一个字符只能在0~6
        	(s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6')) {
        		dp[i] += dp[i - 2];
        	}
        }
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("12"));
	}
}
