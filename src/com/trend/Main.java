package com.trend;
//删除指定的数，将剩余元素向右排列，并将左侧空余位置补1(借助辅助空间解法)
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();	//样例数
		for(int i = 0;i < T;i ++) {
			int N = s.nextInt();
			int[] arr = new int[N];
			for(int j = 0;j < N;j ++) {
				arr[j] = s.nextInt();
			}
			int X = s.nextInt();
			//将元素为X的置为1,并统计1的个数
			List<Integer> list = new ArrayList<Integer>();
			int count = 0;
			for(int j = 0;j < N;j ++) {
				if(arr[j] == X || arr[j] == 1) {
					arr[j] = 1;
					count ++;
				}
				else {
					list.add(arr[j]);
				}
			}
			
			for(int j = 0;j < count;j ++) {
				arr[j] = 1;
			}
			
			int k = 0;
			for(int j = count;j < arr.length;j ++) {
				arr[j] = list.get(k ++);
			}
			
			//遍历
			for(int j = 0;j < N;j ++) {
				System.out.print(arr[j] + " ");
			}
		}
	}
}
