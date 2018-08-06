package com.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*��������ַ�������������0����������ĵ��ǰ�������ĸ����ͬ��
    ��������һ��anagrams��Ҫ�ҵ�������anagrams������
Input:  ["tea","and","ate","eat","den"]
Output:   ["tea","ate","eat"] 
 */
public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
	    if(strs == null || strs.length <= 0)
	    	return res;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for(int i = 0;i < strs.length;i ++) {
	    	String str = sortStr(strs[i]);
	    	if(map.containsKey(str)) {
	    		int value = map.get(str);
	    		value ++;
	    		map.put(str, value);
	    	}
	    	else {
	    		map.put(str, 1);
	    	}
	    }
	    
	    for(int i = 0;i < strs.length;i ++)  {
		    String str = sortStr(strs[i]);
	        if(map.get(str) > 1) {
	    		res.add(strs[i]);
	    	}
	    }
	    return res;
	}
	
	public String sortStr(String str) { //�ַ��������˼�룺��ʹ�ַ������򣬵���ֻҪ��ӦԪ�ظ�����ͬ���������ַ���Ҳ��һ����
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}
	
	public static void main(String[] args) {
		String[] strs = {"tea","and","ate","eat","den"};
		System.out.println(new Anagrams().anagrams(strs));
	}
}
