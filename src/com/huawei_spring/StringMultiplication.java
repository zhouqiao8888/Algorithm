package com.huawei_spring;
/*
 * ��д����������ˡ�����ʵ���������ⳤ�ȵĳ�����(����)��ˣ�������.  
 * ��һ����������A���ַ������ַ���Χ��0��9�����ڶ�����������B���ַ������ַ���Χ��0��9����
 * ���A��B������˵Ľ�������Ϊ�ַ�����    ���磺����1234 4321 ���5332114  
 * ע��str1�ĳ�����m,str2�ĳ�����n,��������˺�ĳ��ȿ�����m+n,Ҳ������m+n-1,�������ĳ�����m+nΪ׼
 * ���������ÿһλ�ϵĳ˻����ɣ����������Ӧλ���ϵĳ˻�+�������ԭ��λ���ϵ���+��λ
 * ���������ÿһλ�ϵ������˻�%10
 * ���������ÿһλ�ϵĽ�λ���˻�/10
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
	        //�жϸ�λ�Ƿ����0,�ҵ���һ����Ϊ0��λ��
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

