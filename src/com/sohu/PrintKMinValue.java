package com.sohu;
import java.util.Arrays;
import java.util.Scanner;
/*
n�������������С��k����
��һ������n��k�ڶ�������n�������������С����k����С���������ö��Ÿ�����
�磺
8 4
4 5 1 6 2 7 3 8
�����
1,2,3,4
 */
public class PrintKMinValue {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();	//���鳤��
			int k = s.nextInt();	//��С��k����
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
					System.out.print(nums[i]);	//���һ������Ҫ���,
				}
			}
		}		
	}
}
