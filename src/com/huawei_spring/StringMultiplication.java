package com.huawei_spring;
/*
 * 编写”长整数相乘”程序，实现两个任意长度的长整数(正数)相乘，输出结果.  
 * 第一行输入数字A的字符串，字符范围（0～9），第二行输入数字B的字符串，字符范围（0～9）。
 * 输出A、B俩数相乘的结果，结果为字符串。    例如：输入1234 4321 输出5332114  
 * 注：str1的长度是m,str2的长度是n,两个数相乘后的长度可能是m+n,也可能是m+n-1,结果数组的长度以m+n为准
 * 结果数组上每一位上的乘积构成：两个数组对应位置上的乘积+结果数组原有位置上的数+进位
 * 结果数组上每一位上的数：乘积%10
 * 结果数组上每一位上的进位：乘积/10
 */
import java.util.Scanner;
public class StringMultiplication{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
	        String str1 = s.nextLine();
	        String str2 = s.nextLine();     
	        int len1 = str1.length();
	        int len2 = str2.length();   
	        int[] result = new int[len1 + len2]; 
	        int carry, multi, i, j;
	        for(i = len1 - 1;i >= 0;i --) {
	        	 carry = 0;
	        	 for(j = len2 - 1;j >= 0;j --) {
	        		 multi = (str1.charAt(i) - '0') * (str2.charAt(j) - '0') + result[i + j + 1] + carry;
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
	        System.out.println(sb.toString());
        }
    }
}

