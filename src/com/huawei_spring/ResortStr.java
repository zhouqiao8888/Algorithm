package com.huawei_spring;
import java.util.*;
/*
 给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。  
举例！假设原始字符串为：  eeefgghhh  
则每种字符出现的次数分别是：  
(1)eee        3次  
(2)f          1次  
(3)gg         2次  
(4)hhh        3次  
重排输出后的字符串如下：  
efghegheh  
 */
public class ResortStr {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			//统计字符串中各个字符出现的次数
			String str = s.next();
			Map<Character, Integer> map = new TreeMap<Character, Integer>();
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
			//寻找最大出现次数(即循环次数),并追加字符串
			Collection<Integer> values = map.values();
			int max = Collections.max(values);			
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i < max;i ++) {
				for(char c : map.keySet()) {
					int value = map.get(c);
					if(value != 0) {
						sb.append(c);
						map.put(c, --value);	//用过了之后次数就减1
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
