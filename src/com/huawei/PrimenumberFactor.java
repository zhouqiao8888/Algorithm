package com.huawei;
/*
 * 输入一个正整数，按照从小到大的顺序输出它的所有质数的因子
 （如180的质数因子为2 2 3 3 5 ） 
  最后一个数后面也要有空格 
  注：实际上不用太多去考虑质数，不断地从2进行因式分解即可
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
