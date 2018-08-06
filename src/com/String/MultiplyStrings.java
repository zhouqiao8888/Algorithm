package com.String;
/*
 * ��������Ǹ��ַ�������˽��
 * ע��str1�ĳ�����m,str2�ĳ�����n,��������˺�ĳ��ȿ�����m+n,Ҳ������m+n-1,�������ĳ�����m+nΪ׼
 * ���������ÿһλ�ϵĳ˻����ɣ����������Ӧλ���ϵĳ˻�+�������ԭ��λ���ϵ���+��λ
 * ���������ÿһλ�ϵ������˻�%10
 * ���������ÿһλ�ϵĽ�λ���˻�/10
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0"))	return "0";
		int len1 = num1.length();
		int len2 = num2.length();
        int[] result = new int[len1 + len2];
        int carry, multi, i, j;
        for(i = len1 - 1;i >= 0;i --) {
        	 carry = 0;
        	 for(j = len2 - 1;j >= 0;j --) {
        		 multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[i + j + 1] + carry;
        		 result[i + j + 1] = multi % 10;
        		 carry = multi / 10;
        	 }
        	 result[i + j + 1] = carry;
        }
  
        //�жϸ�λ�Ƿ����0,�ҵ���һ����Ϊ0��λ��
        i = 0;
        while(i < result.length && result[i] == 0) {
        	i ++;
        }
        StringBuffer sb = new StringBuffer();
        for(;i < result.length;i ++) {
        	sb.append(result[i]);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply("123", "456"));
	}
}
