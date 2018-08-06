package com.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*给定一个可能包含重复数字的数组，返回它所有可能的子集
 *例如s=[1,2,2],它所有的子集为：
 *[2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
 */
public class SubsetsII {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		if(S == null) {
			return res;
		}
		Arrays.sort(S); //先排序		
		findSubset(S, new ArrayList<Integer>(), 0);		
		return res;
	}
	
	public void findSubset(int[] s, ArrayList<Integer> list, int start) {		
		res.add(new ArrayList<Integer>(list));	
		for(int i = start;i < s.length;i ++) {
			if(i > start && s[i] == s[i - 1])
				continue;
			list.add(s[i]);
			findSubset(s, list, i + 1); //往后找，同时要匹配的长度减一
			list.remove(list.size() - 1); //返回上一层，删除最后一个元素
		}	
	}
	
	public static void main(String[] args) {
		int[] num = {1,2};
		ArrayList<ArrayList<Integer>> res = new SubsetsII().subsetsWithDup(num);
		System.out.println(res);
	}
}
