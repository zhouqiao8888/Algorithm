package com.wuyao;
/*
 *����һ���ַ����жϵڶ����ַ������ַ��Ƿ񶼴����ڵ�һ���ַ���������true������false���������м���;������
     �����룺   
  ABCNB51;51NB     
    �����true
 */
import java.util.*;
public class StringJudge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.next();
			String[] strArr = str.split(";");
			String s1 = strArr[0];
			String s2 = strArr[1];
			System.out.println("s1:" + s1 + " s2:" + s2);
			boolean flag = true;
			for(int i = 0;i < s2.length();i ++) {
				char c = s2.charAt(i);
				if(!s1.contains(c + "")) {
					flag = false;
					break;
				}
			}
			System.out.println(flag);
		}
	}
}
