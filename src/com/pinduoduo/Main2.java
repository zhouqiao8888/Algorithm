package com.pinduoduo;

import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); //ÇòÐÇÊý
		int m = s.nextInt();	//Ñ¡Æ±Êý
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i < m;++ i) {
			String str = s.next();
			for(int j = 0;j < str.length();++ j) {
				char c = str.charAt(j);
				if(map.containsKey(j)) {
					int value = map.get(j);
					value = value + (c - 'a');
					map.put(j, value);
				}
				else {
					int value = c - 'a';
					map.put(j, value);
				}
			}
		}
		//System.out.println(map);
		int min = Integer.MAX_VALUE;
		int index = 0;
		for(int key : map.keySet()) {
			int value = map.get(key);
			if(value < min) {	
				min = value;		
				index = key;
			}
		}
		//System.out.println(min);
		int count = 0;
		for(int key : map.keySet()) {
			int value = map.get(key);
			if(value == min) {	
				count ++;				
			}
		}
		//System.out.println(count);
		if(count == 1) {
			System.out.println(index);
		}
		else {
			System.out.println(-1);
		}
	}
}
