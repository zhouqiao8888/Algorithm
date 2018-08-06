package com.pinduoduo;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] str = s.nextLine().split(" ");
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i < str.length;i ++) {
			list.add(Integer.valueOf(str[i]));
		}
		//System.out.println(list);
		int sum = 0;
		for(int i = 0;i < list.size();i ++) {
			sum += list.get(i);
		}
		int res = sum % 300 == 0 ? sum / 300 : sum / 300 + 1;
		System.out.println(res);
	}
}
