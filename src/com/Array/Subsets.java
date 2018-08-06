package com.Array;

import java.util.ArrayList;
import java.util.Arrays;

/*����һ���������ظ����ֵ����飬���������п��ܵ��Ӽ�(ÿ���Ӽ��ǵݼ�)
 *����s=[1,2,3],�����е��Ӽ�Ϊ��
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
		Arrays.sort(S); //������
		for(int i = 0;i <= S.length;i ++) { //�Ӽ����ܵĳ���
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
				findSubset(s, list, i + 1, len - 1); //�����ң�ͬʱҪƥ��ĳ��ȼ�һ
				list.remove(list.size() - 1); //������һ�㣬ɾ�����һ��Ԫ��
			}
		}
	}
	
	ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
		if(S == null) {
			return res2;
		}
		Arrays.sort(S); //������		
		findSubset2(S, new ArrayList<Integer>(), 0);		
		return res2;
	}
	
	public void findSubset2(int[] s, ArrayList<Integer> list, int start) {		
		res2.add(new ArrayList<Integer>(list));	
		for(int i = start;i < s.length;i ++) {
			list.add(s[i]);
			findSubset2(s, list, i + 1); //�����ң�ͬʱҪƥ��ĳ��ȼ�һ
			list.remove(list.size() - 1); //������һ�㣬ɾ�����һ��Ԫ��
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
