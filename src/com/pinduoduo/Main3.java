package com.pinduoduo;

import java.util.*;

public class Main3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); //ÇòÐÇÊý
		int m = s.nextInt();	//Ñ¡Æ±Êý
		List<String> list = new ArrayList<String>();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0;i < m;++ i) {
			String str = s.next();
			for(int j = 0;j < str.length();++ j) {
				char c = str.charAt(j);
				if(map.containsKey(j)) {
					String value = map.get(j);
					value = value + c;
					map.put(j, value);
				}
				else {
					String value = "" + c;
					map.put(j, value);
				}
			}
		}
		//System.out.println(map);
		boolean flag = false;
		for(int i = 0;i < n;i ++) {
			String value = map.get(i);
			int temp = 0;
			for(int j = 0;j < n;j ++) {
				if(j != i && compareTwoString(value, map.get(j))) {
					temp ++;
				}
			}
			if(temp == n - 1) {
				System.out.println(i);
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
	}
	
	public static boolean compareTwoString(String str, String str2) {
		int count = 0;
		for(int i = 0;i < str.length();i ++) {
			if(str.charAt(i) < str2.charAt(i)) {
				count ++;
			}
			else if(str.charAt(i) > str2.charAt(i)) {
				count --;
			}
		}
		return count > 0 ? true : false;
	}
}
