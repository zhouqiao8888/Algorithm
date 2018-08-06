package com.huawei;

import java.util.*;

public class DeleteChar {
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		while(s.hasNext()) {
			String str = s.next();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			//统计字符个数
			for(int i = 0;i < str.length();i ++) {
				char c = str.charAt(i);
				if(map.containsKey(c)) {
					int value = map.get(c);
					map.put(c, ++ value);
				}
				else {
					map.put(c, 1);
				}
			}
			//寻找次数最小的值
			Collection<Integer> coll =  map.values();
			int min = Collections.min(coll);
			//移除出现次数最小的字符
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i < str.length();i ++) {
				char c = str.charAt(i);
				int value = map.get(c);
				if(value != min) {
					sb.append(c);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
