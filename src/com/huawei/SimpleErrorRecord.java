package com.huawei;

import java.util.*;
/*注意两点：一是要用LinkedHashMap,不能用HashMap,因为LinkedHashMap可以保持顺序，而HashMap不能
*二是要输出最后8个记录
*/
public class SimpleErrorRecord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		//System.out.println(getStr("E:\\V1R2\\product\\fpgadriveagdgggggggggggggggggg.c"));
		while(s.hasNext()) {
			String str = s.next();
			str = getStr(str);
			int rows = s.nextInt();
			str = str + " " + rows;
			if(map.containsKey(str)) {
				int count = map.get(str);
				map.put(str, ++ count);
			}
			else {
				map.put(str, 1);
			}
		}		
		//System.out.println(map);
		int count = 0;
        for(String string : map.keySet()){
            count ++;
            if(count > (map.keySet().size() - 8)) //输出最后八个记录
                System.out.println(string + " " + map.get(string));
        }
	}
	
	public static String getStr(String str) {
		int index = str.lastIndexOf("\\");	//'\'在java中是一个转义字符，所以需要用两个代表一个
		str = str.substring(index + 1, str.length());
		if(str.length() > 16) {
			return str.substring(str.length() - 16, str.length());
		}
		return str;
	}
	
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
//		while(s.hasNext()) {
//			String file = s.next();
//            int rows = s.nextInt();
//			String[] sa = file.split("\\\\");
//			String str = sa[sa.length - 1];
//			if(str.length() > 16) {
//				str = str.substring(str.length() - 16);
//			}		
//			str = str + " " + rows;
//			if(map.containsKey(str)) {
//				int count = map.get(str);
//                count ++;
//				map.put(str, count);
//			}
//			else {
//				map.put(str, 1);
//			}
//		}		
//		//System.out.println(map);
//		int count = 0;
//        for(String string:map.keySet()){
//            count ++;
//            if(count > (map.keySet().size() - 8)) //输出最后八个记录
//                System.out.println(string + " " + map.get(string));
//        }
//	}
}
