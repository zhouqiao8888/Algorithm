package com.Array;
/*
 * ����������У�����[100, 4, 200, 1, 3, 2]���������������[1, 2, 3, 4]
 * ע����list�ᷢ�������±�Խ�磬����Ϊlist�ײ������飬���Ƴ�Ԫ�غ󣬳��ȼ�С������Ż�������
 * ��set������ģ�û����ţ�
 */
import java.util.*;
public class Longest_consecutive_sequence {
	/*˼·������set�洢������set���ÿһ���������������¼����û���������У�
	 *��ÿһ������������Ƴ��������������ÿ����ʵ����ֻ������һ�Σ��㷨���Ӷ���O(n)
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
			while(list.contains(cur)) {	//����ϱ߽�
				list.remove(cur);
				cur ++;
				len ++;				
			}
			
			cur = i - 1;
			while(list.contains(cur)) {	//����±߽�
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
