package com.trend;
//删除指定的数，将剩余元素向右排列，并将左侧空余位置补1(不需要辅助空间解法)
import java.util.*;
public class Main2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();	//样例数
		for(int i = 0;i < T;i ++) {
			int N = s.nextInt();
			int[] arr = new int[N];
			for(int j = 0;j < N;j ++) {
				arr[j] = s.nextInt();
			}
			int X = s.nextInt();	//删除的数
			//将元素为X的置为1
			for(int j = 0;j < N;j ++) {
				if(arr[j] == X || arr[j] == 1) {
					arr[j] = 1;
				}
			}
			
			//从后往前遍历找出第一个是1的位置
			int start = 0;
			for(int j = arr.length - 1;j >= 0;j --) {
				if(arr[j] == 1) {
					start = j;
					break;
				}
			}
			
			//从后往前遍历，移动非1的数
			for(int j = start + 1;j >= 0;j --) {
				if(arr[j] != 1) {
					int temp = arr[j];
					arr[j] = arr[start];
					arr[start] = temp;
					start --;
				}
			}
			
			//遍历
			for(int j = 0;j < N;j ++) {
				System.out.print(arr[j] + " ");
			}
			//System.out.println();
		}
	}
}
