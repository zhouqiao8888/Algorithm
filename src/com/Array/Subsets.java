package com.Array;

import java.util.ArrayList;
import java.util.Arrays;

/*给定一个不包含重复数字的数组，返回它所有可能的子集(每个子集非递减)
 *例如s=[1,2,3],它所有的子集为：
 *[3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
 */
public class Subsets {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if(S == null) {
			return res;
		}
		Arrays.sort(S); //先排序
		for(int i = 0;i <= S.length;i ++) { //子集可能的长度
			findSubset(S, new ArrayList<Integer>(), 0, i);
		}
		return res;
	}
	
	public void findSubset(int[] s, ArrayList<Integer> list, int start, int len) {
		if(len < 0)
			return;
		else if(len == 0) {
			res.add(new ArrayList<Integer>(list));
		}
		else {
			for(int i = start;i < s.length;i ++) {
				list.add(s[i]);
				findSubset(s, list, i + 1, len - 1); //往后找，同时要匹配的长度减一
				list.remove(list.size() - 1); //返回上一层，删除最后一个元素
			}
		}
	}
	
	ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
		if(S == null) {
			return res2;
		}
		Arrays.sort(S); //先排序		
		findSubset2(S, new ArrayList<Integer>(), 0);		
		return res2;
	}
	
	public void findSubset2(int[] s, ArrayList<Integer> list, int start) {		
		res2.add(new ArrayList<Integer>(list));	
		for(int i = start;i < s.length;i ++) {
			list.add(s[i]);
			findSubset2(s, list, i + 1); //往后找，同时要匹配的长度减一
			list.remove(list.size() - 1); //返回上一层，删除最后一个元素
		}	
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3};
		ArrayList<ArrayList<Integer>> res = new Subsets().subsets(num);
		ArrayList<ArrayList<Integer>> res2 = new Subsets().subsets2(num);
		System.out.println(res);
		System.out.println(res2);
	}
}
