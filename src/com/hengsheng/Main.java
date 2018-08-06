package com.hengsheng;

import java.util.Scanner;

//将一个合数分解成质因数的乘积12=2*2*3

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();
			for(int i = 2;i <= n / 2;) {
				if(n % i == 0) {
					System.out.print(i + "*");
					n = n / i;
					i = 2;	//能被2整除，下一次仍然从2开始
				}
				else {
					i ++;
				}
			}
			System.out.print(n);	//打印出最后一个质因数
			System.out.println();
		}
	}
}
