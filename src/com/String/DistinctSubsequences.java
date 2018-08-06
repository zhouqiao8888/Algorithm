package com.String;
/*给定两个字符串S和T，求出S中的子序列（相对顺序可变）是T的个数，子序列定义：
*ACE是ABCDE的子序列，而AEC不是
*动态规划解：S是重量，T是背包
*/
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(T.length() == 0) //把S全部删除
			return 1;
		if(S.length() == 0)
			return 0;
		int[][] res = new int[S.length() + 1][T.length() + 1];
		//初始化res
		for(int i = 1;i <= T.length();i ++) {
			res[0][i] = 0;
		}
		
		for(int i = 0;i <= S.length();i ++) {
			res[i][0] = 1;
		}
		
		for(int i = 1;i <= S.length();i ++) {
			for(int j = 1;j <= T.length();j ++) {
				if(S.charAt(i - 1) == T.charAt(j - 1)) {
					res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
				}
				else {
					res[i][j] = res[i - 1][j]; //第i - 1个数和第j - 1个数不匹配，则只能看与第j个数是否匹配 
				}
			}
		}
		return res[S.length()][T.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(new DistinctSubsequences().numDistinct("a", "a"));
	}
}
