package com.Array;
/*
 * 最长连续子序列：例如[100, 4, 200, 1, 3, 2]，最长连续子序列是[1, 2, 3, 4]
 * 注：用list会发生数组下标越界，是因为list底层是数组，当移除元素后，长度减小但是序号还在增加
 * 而set是无序的（没有序号）
 */
import java.util.*;
public class Longest_consecutive_sequence {
	/*思路：利用set存储，对于set里的每一个数，都向上向下检查有没有连续序列，
	 *且每一个数检查过后就移除，这样数组里的每个数实际上只遍历里一次，算法复杂度是O(n)
	 */
	public int longestConsecutive(int[] num) {
		if(num == null || num.length <= 0)	return -1;
		Set<Integer> list = new HashSet<Integer>();	
		for(int i : num) {
			list.add(i);
		}
		
		int maxlen = 0;
		for(int i : num) {
			int cur = i;
			int len = 0;
			while(list.contains(cur)) {	//检查上边界
				list.remove(cur);
				cur ++;
				len ++;				
			}
			
			cur = i - 1;
			while(list.contains(cur)) {	//检查下边界
				list.remove(cur);
				cur --;
				len ++;			
			}
			
			maxlen = Math.max(len, maxlen);
		}
		return maxlen;
	}
	
	public static void main(String[] args) {
		Longest_consecutive_sequence lcs = new Longest_consecutive_sequence();
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(lcs.longestConsecutive(num));
		
	}
}
