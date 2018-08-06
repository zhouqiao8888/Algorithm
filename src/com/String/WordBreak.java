package com.String;
/*
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
 例如给定s ="catsanddog",dict =["cat", "cats", "and", "sand", "dog"]. 
 s是可以由dict中的字符串构成的
 注：某个字符i是否被包含在字典中取决于它前面的任意一个字符j是否被包含在字典中，以及从j到i的这一段字符是否包含在字典中
 */
import java.util.*;
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || dict == null)
        	return false;
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for(int i = 1;i <= s.length();i ++) {
        	for(int j = i - 1;j >= 0;j --) {	
        		if(flag[j] && dict.contains(s.substring(j, i))) {
        			flag[i] = true;
        			break;
        		}
        		else {
        			flag[i] = false;
        		}
        	}
        }
        return flag[s.length()];
    }
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak(s, dict));
	}
}
