package com.Array;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 在候选数组C中取出一些数字组合(数字可以重复使用)，使得他们的和为T
 * 例如：候选数组C={2,3,6,7},T=7,组合有[7],[2, 2, 3]
 */
public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(candidates == null || candidates.length <= 0)
			return res;
		Arrays.sort(candidates);
		dfs(candidates, target, 0, res, list);
		return res;
    }
	
	public void dfs(int[] candidates, int target, int start, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
		if(target == 0) {
			ArrayList<Integer> temp = (ArrayList<Integer>)list.clone();
			res.add(temp);
			return;
		}
		for(int i = start;i < candidates.length;i ++) {
			if(candidates[i] > target)
				return;
			list.add(candidates[i]);
			dfs(candidates, target - candidates[i], i, res, list);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		System.out.println(new CombinationSum().combinationSum(candidates, 7));
	}
}
