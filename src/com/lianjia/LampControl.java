package com.lianjia;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * 有n个开关，每个开关可控制若干个灯泡，请问最多可控制多少个灯泡
 * 注：每个开关控制的灯泡会有重复，利用Set可自然去重
 */
public class LampControl {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();	//n组开关
		Set<Integer> set = new HashSet<Integer>();	//存储灯泡序号
		int[] k = new int[n];	//存储开关控制的灯泡个数
		for(int i = 0;i < n;i ++) {
			k[i] = s.nextInt();
			for(int j = 0;j < k[i];j ++) {
				set.add(s.nextInt());
			}
		}		
		System.out.println(set.size());
	}
}
