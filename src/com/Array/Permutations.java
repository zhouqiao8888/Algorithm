package com.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 输入一个数组(没有重复元素),按字典序打印出该数组中数字的所有排列。例如给定[1,2,3]
 * 返回[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1]. 
 */
public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length <= 0)
			return res;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i < num.length;i ++) {
			list.add(num[i]);
		}
		res.add(list);
		for(int i = 0;i < num.length - 1;i ++) { //循环次数
			int size = res.size();
			for(int j = 0;j < size;j ++) {
				list = res.get(j);
				getRes(res, list, i);
			}
		}
		Collections.sort(res, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				for(int i = 0;i < o1.size();i ++) {
					if(o1.get(i) != o2.get(i)) {
						return o1.get(i) - o2.get(i);
					}
				}
				return 0;
			}		
		});
		return res;
	}
	
	public void getRes(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int index) {
		for(int i = index + 1;i < list.size();i ++) {
			//先拷贝一份list，再交换与index指向的值
			ArrayList<Integer> list2 = (ArrayList<Integer>)list.clone();
			int temp = list2.get(i);
			list2.set(i, list2.get(index));
			list2.set(index, temp);			
			res.add(list2);
		}
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3};
		System.out.println(new Permutations().permute(num));
	}
}
