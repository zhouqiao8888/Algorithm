package com.Array;

import java.util.ArrayList;

/*
 * 给定一个字符串S和一个字符串数组L，L中的字符串长度都相等，
 * 找出S中所有的子串恰好包含L中所有字符各一次，返回子串的位置，例如
 * S:"barfoothefoobarman"
   L:["foo", "bar"] 
  找到"barfoo"和"foobar",返回:[0,9].
 */
public class SubstringWithConcatenationOfAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(S == null || S.length() <= 0 
		  || L == null || L.length <= 0 || S.length() < L[0].length() * L.length)
			return res;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0;i < L.length;i ++) { 
			list.add(L[i]);
		}
		int len = L[0].length();
		for(int i = 0;i <= S.length() - len;i ++) {
			ArrayList<String> temp = new ArrayList<String>(list);
			String subStr = S.substring(i, i + len);
			if(temp.contains(subStr)) { //匹配到了第一个子串
				temp.remove(subStr);
				for(int j = i + len;j <= S.length() - len;j = j + len) { //判断从这个起点往后，能不能匹配完所有的子串
					subStr = S.substring(j, j + len);
					if(temp.contains(subStr)) {
						temp.remove(subStr);
					}
					else 
						break;
				}
				if(temp.isEmpty()) //匹配完了，将这个起始位置加入
					res.add(i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String S = "a";
		String[] L = {"a"};
		System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(S, L));
	}
	
}
