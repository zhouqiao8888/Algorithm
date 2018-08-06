package com.Array;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * 在候选数组C中取出一些数字组合(数字不可以重复使用)，使得他们的和为T
 * 例如：候选数组C={10,1,2,7,6,5,1},T=8,组合有[1,7],[1,2,5],[2,6],[1,1,6]
 */
public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(num == null || num.length <= 0)
			return res;
		Arrays.sort(num);
		dfs(num, target, 0, res, list);
		return res;        
	}
	
	public void dfs(int[] num, int target, int start, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
		if(target == 0) {
			if(!res.contains(list)) {
				ArrayList<Integer> temp = (ArrayList<Integer>)list.clone();
				res.add(temp);
			}
			return;
		}
		for(int i = start;i < num.length;i ++) {
			if(num[i] > target)
				return;
			list.add(num[i]);
			dfs(num, target - num[i], i + 1, res, list);	//当前i位置的元素不能重复使用，因此指针后移
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,5,1};
		System.out.println(new CombinationSumII().combinationSum2(candidates, 8));
	}
}
