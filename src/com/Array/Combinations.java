package com.Array;

import java.util.ArrayList;

/*
 * 给定n和k,返回长度为k,且范围为1-n的所有组合,例n=4,k=2
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],

 */
public class Combinations {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0)
        	return res;		
		findCombination(new ArrayList<Integer>(), 1, n, k);		
		return res;
    }
	
	public void findCombination(ArrayList<Integer> list, int start, int end, int len) {
		if(len < 0)
			return;
		else if(len == 0) {
			res.add(new ArrayList<Integer>(list));
		}
		else {
			for(int i = start;i <= end;i ++) {
				list.add(i);
				findCombination(list, i + 1, end, len - 1); //往后找，同时要匹配的长度减一
				list.remove(list.size() - 1); //返回上一层，删除最后一个元素
			}
		}
	}
	
	public static void main(String[] args) {
		Combinations cs = new Combinations();
		cs.combine(4, 2);
		System.out.println(cs.res);
	}
}
