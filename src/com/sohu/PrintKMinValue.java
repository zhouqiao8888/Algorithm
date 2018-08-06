package com.sohu;
import java.util.Arrays;
import java.util.Scanner;
/*
n个整数，输出最小的k个，
第一行输入n，k第二行输入n个整数，输出从小到大k个最小整数，并用逗号隔开。
如：
8 4
4 5 1 6 2 7 3 8
输出：
1,2,3,4
 */
public class PrintKMinValue {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();	//数组长度
			int k = s.nextInt();	//最小的k个数
			int[] nums = new int[n];
			for(int i = 0;i < n;i ++) {
				nums[i] = s.nextInt();
			}
			Arrays.sort(nums);
			for(int i = 0;i < k;i ++) {
				if(i != k - 1) {
					System.out.print(nums[i] + ",");
				}
				else {
					System.out.print(nums[i]);	//最后一个不需要输出,
				}
			}
		}		
	}
}
