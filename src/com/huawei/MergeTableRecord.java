package com.huawei;

import java.util.*;

/*���ݱ��¼��������������ֵ����Ա�������ͬ�ļ�¼���кϲ���
 *������ͬ��������ֵ����������㣬�������keyֵ������������
 */
public class MergeTableRecord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();	//�Զ���key����
		TreeSet<Integer> set = new TreeSet<Integer>();
 		for(int i = 0;i < num;i ++) {
			int key = s.nextInt();
			int value = s.nextInt();
			set.add(key);
			if(!map.containsKey(key)){
				map.put(key, value);
			}
			else {
				int v = map.get(key);
				map.put(key, value + v);
			}
		}
	
 		Iterator<Integer> iterator = set.iterator();
 		while(iterator.hasNext()) {
 			int key = iterator.next();
 			System.out.println(key + " " + map.get(key));
 		}
		
	}
}
