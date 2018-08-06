package com.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*����һ�����ܰ����ظ����ֵ����飬���������п��ܵ��Ӽ�
 *����s=[1,2,2],�����е��Ӽ�Ϊ��
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
		Arrays.sort(S); //������		
		findSubset(S, new ArrayList<Integer>(), 0);		
		return res;
	}
	
	public void findSubset(int[] s, ArrayList<Integer> list, int start) {		
		res.add(new ArrayList<Integer>(list));	
		for(int i = start;i < s.length;i ++) {
			if(i > start && s[i] == s[i - 1])
				continue;
			list.add(s[i]);
			findSubset(s, list, i + 1); //�����ң�ͬʱҪƥ��ĳ��ȼ�һ
			list.remove(list.size() - 1); //������һ�㣬ɾ�����һ��Ԫ��
		}	
	}
	
	public static void main(String[] args) {
		int[] num = {1,2};
		ArrayList<ArrayList<Integer>> res = new SubsetsII().subsetsWithDup(num);
		System.out.println(res);
	}
}
