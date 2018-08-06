package com.huawei;

import java.util.*;

public class Team {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();
			List<Integer> num = new ArrayList<Integer>();;			
			for(int i = 0;i < n;i ++) {
				num.add(s.nextInt());
			}
			
			//找出最大身高位置
			int max = Collections.max(num);
			int i = 0;
			int count = 0;
			int temp = num.get(i);
			for(;i < n - 2;i ++) {
				if(num.get(i) == max) {
					break;
				}
				if(num.get(i + 1) <= temp) {
					count ++;
				}
				if(num.get(i + 1) > temp) {
					temp = num.get(i + 1);
				}
			}
			
			temp = num.get(i);
			for(;i < n - 1;i ++) {
				if(num.get(i + 1) >= temp) {
					count ++;
				}
				else {
					temp = num.get(i + 1);
				}
			}
			System.out.println(count);
		}
	}
}
