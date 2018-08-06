package com.dajiang;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 	//n––
		int m = s.nextInt();	//m¡–
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		for(int i = 0;i < n;i ++) {
			for(int j = 0;j < m;j ++) {
				a[i][j] = s.nextInt();
				b[i][j] = a[i][j];
			}
		}
		boolean flag = false;
		boolean res_flag = true;
		outer:
		for(int i = 0;i < n;i ++) {
			for(int j = 0;j < m;j ++) {
				flag = false;
				for(int k = 0;k < m;k ++) {
					if(a[i][k] == 1) {
						flag = true;
						break;
					}
				}
				if((flag && a[i][j] == 1) || (!flag && a[i][j] == 0)) {	//◊¥Ã¨∑˚∫œ
					continue;
				}
				else {
					for(int k = 0;k < n;k ++) {
						if(a[k][j] == 1) {
							flag = true;
							break;
						}
					}
				}
				if((flag && a[i][j] == 1) || (!flag && a[i][j] == 0)) {
					continue;
				}
				else {
					System.out.println("NO");
					res_flag = false;
					break outer;
				}
			}
		}
		
		if(res_flag) {
			System.out.println("YES");
		}
	}
}
