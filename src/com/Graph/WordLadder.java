package com.Graph;
/*
 *给定两个String(start, end),和一个字典dict,
 *满足从start到end转化的最短路径数,每次转化只能从dict中取字符串,且只能改变一个字符
 *求转化的最短路径长度，例如start="hit",end="cog",dict={"hot","dot","dog","lot","log"}
 *"hit" -> "hot" -> "dot" -> "dog" -> "cog"
 *长度为5
 */
import java.util.*;
public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if(start == null || end == null || dict.isEmpty())
			return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int res = 1;
        String str = null;
        while(!queue.isEmpty()) {
	        int size = queue.size();	//一层遍历
	        while(size > 0) {
	        	str = queue.poll();
	        	size --;
	        	if(isDifferOne(str, end)) {	//一旦匹配到end,立刻返回
	        		return res + 1;
	        	}
	        	Iterator<String> iter = dict.iterator();
	        	while(iter.hasNext()) {
	        		String temp = iter.next();
	        		if(isDifferOne(str, temp)) { //匹配到仅相差一位的
	        			queue.offer(temp);
	        			iter.remove();	//遍历过的一定要从字典中移除，因为遍历过的一定已经加入队列中，作为一条分支了
	        		}
	        	}
	        }
	        res ++;
        }
        return 0;
    }
	
	public boolean isDifferOne(String s1, String s2) { 
		int count = 0;
		for(int i = 0;i < s1.length();i ++){
			if(s1.charAt(i) != s2.charAt(i)) {
				count ++;
			}
		}
		return count == 1 ? true : false;
	}
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		WordLadder wl = new WordLadder();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(wl.ladderLength(start, end, dict));
		//dict={"hot","dot","dog","lot","log"}
	}
}
