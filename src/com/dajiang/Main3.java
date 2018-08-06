package com.dajiang;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();	//n´Î			
			for(int i = 0;i < n;i ++) {
				int num = s.nextInt(); 
				int[] h = new int[num];
				int[] w = new int[num];
				double sum_h = 0;
				double sum_w = 0;
				for(int j = 0;j < num;j ++) {
					h[j] = s.nextInt();
					w[j] = s.nextInt();
					sum_h += h[j];
					sum_w += w[j];
				}	
				int res = (int) Math.min(Math.ceil(sum_h / 2), Math.ceil(sum_w / 2));
				System.out.println("#Case "+ (i + 1) + ": " + res);
			}
		}
	}
}
