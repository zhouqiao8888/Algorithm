package com.Graph;
/*
 *��������String(start, end),��һ���ֵ�dict,
 *�����start��endת�������·����,ÿ��ת��ֻ�ܴ�dict��ȡ�ַ���,��ֻ�ܸı�һ���ַ�
 *��ת�������·�����ȣ�����start="hit",end="cog",dict={"hot","dot","dog","lot","log"}
 *"hit" -> "hot" -> "dot" -> "dog" -> "cog"
 *����Ϊ5
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
	        int size = queue.size();	//һ�����
	        while(size > 0) {
	        	str = queue.poll();
	        	size --;
	        	if(isDifferOne(str, end)) {	//һ��ƥ�䵽end,���̷���
	        		return res + 1;
	        	}
	        	Iterator<String> iter = dict.iterator();
	        	while(iter.hasNext()) {
	        		String temp = iter.next();
	        		if(isDifferOne(str, temp)) { //ƥ�䵽�����һλ��
	        			queue.offer(temp);
	        			iter.remove();	//��������һ��Ҫ���ֵ����Ƴ�����Ϊ��������һ���Ѿ���������У���Ϊһ����֧��
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
