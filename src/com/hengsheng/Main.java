package com.hengsheng;

import java.util.Scanner;

//��һ�������ֽ���������ĳ˻�12=2*2*3

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();
			for(int i = 2;i <= n / 2;) {
				if(n % i == 0) {
					System.out.print(i + "*");
					n = n / i;
					i = 2;	//�ܱ�2��������һ����Ȼ��2��ʼ
				}
				else {
					i ++;
				}
			}
			System.out.print(n);	//��ӡ�����һ��������
			System.out.println();
		}
	}
}
