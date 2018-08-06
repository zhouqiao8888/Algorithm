package com.String;
/*
 * 两个字符串s1,s2,将s1转化为s2,求最小的转化次数,转化规则：插入、删除、替换
 * dp[i][j]表示i长的字符串转化为j长的字符串所需的最小转化次数
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if(word1 == null && word2 == null)
			return 0;
		if(word1 == null && word2 != null)
			return word2.length();
		if(word1 != null && word2 == null)
			return word1.length();
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1]; //前者表示word1可能的长度，后者表示word2可能的长度
		//初始化
		for(int i = 0;i <= len1;i ++) { //删除
			dp[i][0] = i;
		}
		
		for(int i = 0;i <= len2;i ++) { //插入
			dp[0][i] = i;
		}
		
		for(int i = 1;i <= len1;i ++) {
			for(int j = 1;j <= len2;j ++) {
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) { //当前字符匹配，则当前最少次数和前一项最少次数相同
					dp[i][j] = dp[i - 1][j - 1];
				}
				else {  //不匹配，则意味着要删除(长度减1)、增加(长度加1)、修改(长度不变)，但不管怎样，转化次数都加1
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[len1][len2];
    }
	
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "abdddd";
		System.out.println(new EditDistance().minDistance(s1, s2));
	}
}
