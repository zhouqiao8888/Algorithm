package com.String;
/*
 * 输出两个非负字符串的相乘结果
 * 注：str1的长度是m,str2的长度是n,两个数相乘后的长度可能是m+n,也可能是m+n-1,结果数组的长度以m+n为准
 * 结果数组上每一位上的乘积构成：两个数组对应位置上的乘积+结果数组原有位置上的数+进位
 * 结果数组上每一位上的数：乘积%10
 * 结果数组上每一位上的进位：乘积/10
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
  
        //判断高位是否存在0,找到第一个不为0的位置
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
