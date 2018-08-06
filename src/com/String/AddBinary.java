package com.String;
/*
 * ���������������ַ������������ǵĺ�(ͬ��Ҳ�Ƕ������ַ���)
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if(a == null && b == null)
			return null;
		if(a == null && b != null)
			return b;
		if(a != null && b == null)
			return a;
		int len1 = a.length();
		int len2 = b.length();
		a = new StringBuilder(a).reverse().toString(); //��ת�ַ���,�������
		b = new StringBuilder(b).reverse().toString();
		if(len1 < len2) {
			return getSum(a, b, len1, len2);
		}
		else {
			return getSum(b, a, len2, len1);
		}
	}
	
	public String getSum(String a, String b, int len1, int len2) {
		int add = 0;
		String res = new String();
		for(int i = 0;i < len1;i ++) {
			res = ((b.charAt(i) - '0') + (a.charAt(i) - '0') + add) % 2 + res;
			add = ((b.charAt(i) - '0') + (a.charAt(i) - '0') + add) / 2;
		}
		for(int i = len1;i < len2;i ++) {
			res = ((b.charAt(i) - '0') + add) % 2 + res;
			add = ((b.charAt(i) - '0') + add) / 2;
		}
		if(add == 1) { //����Դ��ڽ�λ
			res = 1 + res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String a = "0";
		String b = "1";
		System.out.println(new AddBinary().addBinary(a, b));
	}
}
