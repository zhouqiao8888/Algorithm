package com.huawei;
/*
 * ����һ�������������մ�С�����˳�����������������������
 ����180����������Ϊ2 2 3 3 5 �� 
  ���һ��������ҲҪ�пո� 
  ע��ʵ���ϲ���̫��ȥ�������������ϵش�2������ʽ�ֽ⼴��
 */
import java.util.Scanner;
public class PrimenumberFactor {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long num = s.nextLong();
		while(num != 1) {
			for(int i = 2;i <= num;i ++) {
				if(num % i == 0) {
					num = num / i;
					System.out.print(i + " ");
					break;
				}
			}
		}
	}
}
