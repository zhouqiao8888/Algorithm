package com.String;
/*
 *�ҳ�ʹһ���ַ����������ֶ��ǻ��Ĵ�����С�з�
 */
public class PalindromePartitioningII {
	
	int[][] dp = new int[1000][1000];
	public int minCut(String s) {
		for(int p = 0;p < s.length();p ++) {	//������ָ��j�ķ�Χ
			for(int i = 0, j = p;j < s.length();i ++, j ++) {
				dp[i][j] = computCut(i, j, s);
			}
		}
		return dp[0][s.length() - 1];
	}
	
	public int computCut(int i, int j, String s) {	//�����i��j���ַ�������С�з���
		String subStr = s.substring(i, j + 1);
		if(isPalindrome(subStr)) {
			return 0;
		}
		int min = s.length();
		for(int p = i;p < j;p ++) {
			int c1 = dp[i][p];
			int c2 = dp[p + 1][j];
			int c = c1 + c2 + 1;
			min = Math.min(min, c);
		}
		return min;
	}
	
	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		for(;i < s.length() / 2;i ++) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			j --;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String s = "abcd";
		int min = pp.minCut(s);
		System.out.println(min);
	}
}
