package com.String;
/*
 * 请实现一个函数用来匹配包括'？'和'*'的正则表达式。
 * 模式中的字符'？'表示任意一个字符，而'*'可以匹配任意序列(包含空串)。
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        if((s == null && p == null) || (s.length() == 0 && p.length() == 0))
            return true;
        if(p.length() == 0 && s.length() != 0)
            return false;
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i ++){
            // 第一行，匹配字符为空，所以考虑待匹配字符为*的情况
            if(p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        }
        for(int i = 1; i <= s.length(); i ++){
            for(int j = 1; j <= p.length(); j ++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                if(p.charAt(j - 1) == '*') //dp[i][j - 1] 没用到*，dp[i - 1][j]用到了*
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }
         
        return dp[s.length()][p.length()];
    }
	
	public static void main(String[] args) {
		System.out.println(new WildcardMatching().isMatch("a", "?*?"));
	}
}
