package com.Array;
/*给定如下的矩形，自上而下，找出最小的路径和
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
如上，最小路径为：2,3,5,1
思路：发现规律，假设第i层选取了下标为j的数，则第i + 1层只能选取下标为j或j + 1的数
*/
import java.util.ArrayList;
public class MinimumTotal {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle == null)
			return 0;
		return DFS(triangle, 0, 0);
    }
	
	//i代表层数，j代表符号条件的最小值下标
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
