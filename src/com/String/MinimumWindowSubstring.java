package com.String;
/*
 * 给定两个字符串S和T，找到S包含T中所有字符的最小滑动窗口，例如
 * S ="ADOBECODEBANC"
   T ="ABC"
   最小滑动窗口为：BANC 
 注：本题较难，要注意分析
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if(S == null || S.length() <= 0 || T == null || T.length() <= 0) {
			return "";
		}
		//统计T中各个字符的个数
		int[] map = new int[256];
		for(int i = 0;i < T.length();i ++) {
			map[T.charAt(i)] ++;
		}
		int start = 0; //窗口起点
		int end = 0; //窗口终点
		int count = T.length(); //T中待匹配的字符个数
		int begin = start; //当匹配时，记录此时窗口的起点
		int d = Integer.MAX_VALUE;	//当匹配时，记录窗口的长度
		while(end < S.length()) {
			if(map[S.charAt(end ++)] -- > 0) {  //不管是否匹配，尾指针end都要加1，另外map中的字符统计次数都要减1（不匹配为负，匹配减1）
				count --; //当S的字符匹配到T中的字符时，待匹配的字符个数减1
			}
			while(count == 0) { //完成了一次匹配
				if(end - start < d) { //更新d，同时记录此时窗口的起点
					d = end - start;
					begin = start;
				}
				if(map[S.charAt(start ++)] ++ == 0) { //完成了一次匹配后，头指针加1，寻求下一次匹配，且这些字符被移除了之后，相当于原先的匹配都失效了，因此对应的map槽点数值都要加1
					count ++;  //如果遇到次数为0的字符，说明该字符先前完成了匹配，现在指针右移，该字符被移除窗口，则待匹配的字符个数要加1
				}
			}
		}
		return d == Integer.MAX_VALUE ? "" : S.substring(begin, begin + d);
	}
	
	public static void main(String[] args) {
		String S = "ab";
		String T = "a";
		System.out.println(new MinimumWindowSubstring().minWindow(S, T));
	}
}
