package com.Array;
/*�������µľ��Σ����϶��£��ҳ���С��·����
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
���ϣ���С·��Ϊ��2,3,5,1
˼·�����ֹ��ɣ������i��ѡȡ���±�Ϊj���������i + 1��ֻ��ѡȡ�±�Ϊj��j + 1����
*/
import java.util.ArrayList;
public class MinimumTotal {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle == null)
			return 0;
		return DFS(triangle, 0, 0);
    }
	
	//i���������j���������������Сֵ�±�
	public int DFS(ArrayList<ArrayList<Integer>> triangle, int i, int j) {
		int sum = triangle.get(i).get(j);
		if(i + 1 < triangle.size()) {
			sum += Math.min(DFS(triangle, i + 1, j), DFS(triangle, i + 1, j + 1));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a1.add(2);
		a2.add(3);
		a2.add(4);
		a3.add(6);
		a3.add(5);
		a3.add(7);
		a4.add(4);
		a4.add(1);
		a4.add(8);
		a4.add(3);
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		MinimumTotal mt = new MinimumTotal();
		System.out.println(mt.minimumTotal(triangle));
	}
}
