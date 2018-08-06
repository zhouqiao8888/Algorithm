package com.String;
/*
 * �����ַ���s1,s2,��s1ת��Ϊs2,����С��ת������,ת�����򣺲��롢ɾ�����滻
 * dp[i][j]��ʾi�����ַ���ת��Ϊj�����ַ����������Сת������
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
		int[][] dp = new int[len1 + 1][len2 + 1]; //ǰ�߱�ʾword1���ܵĳ��ȣ����߱�ʾword2���ܵĳ���
		//��ʼ��
		for(int i = 0;i <= len1;i ++) { //ɾ��
			dp[i][0] = i;
		}
		
		for(int i = 0;i <= len2;i ++) { //����
			dp[0][i] = i;
		}
		
		for(int i = 1;i <= len1;i ++) {
			for(int j = 1;j <= len2;j ++) {
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) { //��ǰ�ַ�ƥ�䣬��ǰ���ٴ�����ǰһ�����ٴ�����ͬ
					dp[i][j] = dp[i - 1][j - 1];
				}
				else {  //��ƥ�䣬����ζ��Ҫɾ��(���ȼ�1)������(���ȼ�1)���޸�(���Ȳ���)��������������ת����������1
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
