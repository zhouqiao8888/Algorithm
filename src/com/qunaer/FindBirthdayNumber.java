package com.qunaer;

import java.util.Scanner;

/*
 * �����������֤��(18λ)�����ظ����֤�ĳ���������Ϣ��������֤��ʽ���ԣ������ERROR����
 * ��7��14λ���ֱ�ʾ�������ꡢ�¡��գ�
 */
public class FindBirthdayNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			String str = s.next();
			if(str.length() != 18) {
				System.out.println("ERROR");
			}
			else {
				System.out.println(str.substring(6, 14));
			}
		}
	}
}
