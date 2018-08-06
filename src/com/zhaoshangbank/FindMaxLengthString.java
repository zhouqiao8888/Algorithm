package com.zhaoshangbank;
/*
 * ����һ���ǿ��ַ������ж�����ַ����Ƿ���������һ���Ӵ������βƴ�ӹ��ɵġ�
 * ����ַ������������������������������������Ӵ�����������������������false��
 * ���磺����abcabc,����Ӵ���abc
 * ˼·��ԭ���ĳ���һ�����Ӵ����ȵ�����������������һ������
 * �ж�str.charAt(i)�Ƿ����str.charAt(i % sublen),i�ɴ�sublen��ʼ����
 */
public class FindMaxLengthString {
	public String findSubString(String str) {
		int strlen = str.length();
		int sublen = str.length() - 1;
		while(sublen > 0) {
			boolean flag = true;
			if(strlen % sublen == 0) {
				for(int i = sublen;i < strlen;i ++) {
					if(str.charAt(i) != str.charAt(i % sublen)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					return str.substring(0, sublen);
				}
			}
			
			if(strlen % sublen != 0 || !flag) {	//�Ӵ����Ȳ����ϻ��߳��ȷ��ϵ���ǰ���ַ�����ƥ��
				sublen --;
			}		
		}
		return null;
	}
	
	public static void main(String[] args) {
		FindMaxLengthString fs = new FindMaxLengthString();
		System.out.println(fs.findSubString("cabcabcab"));
	}
}
