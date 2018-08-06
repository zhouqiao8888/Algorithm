package com.String;
/*������ӳ���ϵ��'A' -> 1��'B' -> 2��...��'Z' -> 26
 ����������Ϣ12���������Խ����"AB"(1 2) or"L"(12). 2��
 */
public class DecodeWays {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
        	return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= s.length();i ++) {
        	if(s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') { //��ǰһ���ַ���Ϊ1~9����ǰ�ַ�����Ϊ��������
        		dp[i] += dp[i - 1];
        	}
        	if(s.charAt(i - 2) == '1' || //����ǰ���������ַ�Ϊ1����ǰ��һ���ַ�����Ϊ����������Ϊ2����ǰ��һ���ַ�ֻ����0~6
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
