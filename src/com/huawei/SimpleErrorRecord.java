package com.huawei;

import java.util.*;
/*ע�����㣺һ��Ҫ��LinkedHashMap,������HashMap,��ΪLinkedHashMap���Ա���˳�򣬶�HashMap����
*����Ҫ������8����¼
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
            if(count > (map.keySet().size() - 8)) //������˸���¼
                System.out.println(string + " " + map.get(string));
        }
	}
	
	public static String getStr(String str) {
		int index = str.lastIndexOf("\\");	//'\'��java����һ��ת���ַ���������Ҫ����������һ��
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
//            if(count > (map.keySet().size() - 8)) //������˸���¼
//                System.out.println(string + " " + map.get(string));
//        }
//	}
}
