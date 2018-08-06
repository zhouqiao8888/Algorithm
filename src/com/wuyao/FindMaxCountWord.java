package com.wuyao;
/*��ӡ��һ�������г��ִ��������Ǹ�����
  ����֮���ǿո�
*/
import java.util.*;

public class FindMaxCountWord {
	public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
        	String str = s.nextLine();
        	String[] sa = str.split(" ");
        	HashMap<String, Integer> map = new HashMap<String, Integer>();
        	for(int i = 0;i < sa.length;i ++) {
        		String key = sa[i];
        		if(map.containsKey(key)) {
        			int value = map.get(key);
        			value ++;
        			map.put(key, value);
        		}
        		else {
        			map.put(key, 1);
        		}
        	}
        	int max = Collections.max(map.values());
        	//System.out.println(max);
        	for(int i = 0;i < sa.length;i ++) {
        		String key = sa[i];        		
        		if(map.get(key) == max) {
        			System.out.println(key);
        			break;
        		}
        	}
        }
	}
}
