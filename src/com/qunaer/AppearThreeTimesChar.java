package com.qunaer;
/*
 * 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
 * 注意：是首次出现3次，不是总共出现3次，所以map要一边放一边查次数，而且还是英文字符
 */
import java.util.*;

public class AppearThreeTimesChar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//统计次数
		for(int i = 0;i < str.length();i ++) {
			char c = str.charAt(i);
			if(c != ' ') {
				if(!map.containsKey(c)) {
					map.put(c, 1);
					//System.out.println(c + " " + 1);
				}
				else {
					int value = map.get(c);
					value ++;
					//System.out.println(c + " " + value);
					if(value >= 3 && (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')) {
						System.out.println(c);
						break;
					}
					else {
						map.put(c, value);
					}
				}
		   }
		}
		//System.out.println(map);

	}
}
