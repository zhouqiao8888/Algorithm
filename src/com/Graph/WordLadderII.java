package com.Graph;
/*
 *给定两个String(start, end),和一个字典dict,
 *满足从start到end转化的最短路�?,每次转化只能从dict中取字符�?,且只能改变一个字�?
 *求转化的�?有最短路径，例如start="hit",end="cog",dict={"hot","dot","dog","lot","log"}
 *"hit" -> "hot" -> "dot" -> "dog" -> "cog"
 *"hit" -> "hot" -> "lot" -> "log" -> "cog"
 */
import java.util.*;
public class WordLadderII {
	
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		WordLadderII wl = new WordLadderII();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		//System.out.println(wl.findLadders(start, end, dict));
		//dict={"hot","dot","dog","lot","log"}
	}
}
