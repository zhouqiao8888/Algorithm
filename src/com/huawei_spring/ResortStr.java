package com.huawei_spring;
import java.util.*;
/*
 ����һ��ԭʼ�ַ��������ݸ��ַ�����ÿ���ַ����ֵĴ���������ASCII�����˳�����µ��������  
����������ԭʼ�ַ���Ϊ��  eeefgghhh  
��ÿ���ַ����ֵĴ����ֱ��ǣ�  
(1)eee        3��  
(2)f          1��  
(3)gg         2��  
(4)hhh        3��  
�����������ַ������£�  
efghegheh  
 */
public class ResortStr {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			//ͳ���ַ����и����ַ����ֵĴ���
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
			//Ѱ�������ִ���(��ѭ������),��׷���ַ���
			Collection<Integer> values = map.values();
			int max = Collections.max(values);			
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i < max;i ++) {
				for(char c : map.keySet()) {
					int value = map.get(c);
					if(value != 0) {
						sb.append(c);
						map.put(c, --value);	//�ù���֮������ͼ�1
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
