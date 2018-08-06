package com.String;
import java.util.*;
/*
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
   Return all such possible sentences. 
���磬����s ="catsanddog",dict =["cat", "cats", "and", "sand", "dog"]. 
���ܽ��Ϊ��["cats and dog", "cat sand dog"]. 
 */
public class WordBreakII {
	//���ݷ�
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		if(s == null || dict == null)	return null;
		ArrayList<String> res = DFS(s, dict, new HashMap<String, ArrayList<String>>());
		//Collections.sort(res);
		return res;
    }
	
	public ArrayList<String> DFS(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
		if(map.containsKey(s)) {
			return map.get(s);
		}
		ArrayList<String> list = new ArrayList<String>(); 
		if(s.length() == 0) {
			list.add("");
			return list;
		}
        for(String str : dict) {
        	if(s.startsWith(str)) {	//�ж��ַ����Ŀ�ͷ�Ƿ����ֵ��е�ĳ���ַ���
        		for(String str2 : DFS(s.substring(str.length()), dict, map)) {
        			list.add(str + (str2 == "" ? "" : " ") + str2);
        		}
        	}
        }
        map.put(s, list);	
        return list;
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aaa");
//		dict.add("and");
//		dict.add("sand");
//		dict.add("dog");
		System.out.println(dict);
		WordBreakII wb = new WordBreakII();
		System.out.println(wb.wordBreak(s, dict));
	}
}
