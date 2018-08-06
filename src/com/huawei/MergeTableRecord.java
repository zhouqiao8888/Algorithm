package com.huawei;

import java.util.*;

/*数据表记录包含表索引和数值，请对表索引相同的记录进行合并，
 *即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 */
public class MergeTableRecord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();	//自动对key排序
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
