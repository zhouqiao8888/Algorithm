package com.qunaer;
/*
 * ����һ��Ӣ���ַ���,��дһ�δ����ҳ�����ַ��������ȳ������ε��Ǹ�Ӣ���ַ���
 * ע�⣺���״γ���3�Σ������ܹ�����3�Σ�����mapҪһ�߷�һ�߲���������һ���Ӣ���ַ�
 */
import java.util.*;

public class AppearThreeTimesChar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//ͳ�ƴ���
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
