package com.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*如果几个字符串（个数大于0），是乱序的但是包含的字母都相同，
    则它们是一组anagrams，要找到所有组anagrams，例如
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
	
	public String sortStr(String str) { //字符串排序的思想：即使字符串乱序，但是只要对应元素个数相同，排序后的字符串也是一样的
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}
	
	public static void main(String[] args) {
		String[] strs = {"tea","and","ate","eat","den"};
		System.out.println(new Anagrams().anagrams(strs));
	}
}
