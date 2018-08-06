package com.Array;

import java.util.*;

/*帕斯卡三角：除第一个数和最后一个数外，中间的任意一个数都等于顶上两个数的累加
 例如：输入rowIndex = 4，输出如下，要求空间复杂度为O(n)
 *  1
 * 1 1
 *1 2 1
 1 3 3 1
 */
public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
		if(numRows <= 0)
			return resList;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i < numRows;i ++) {	 //循环次数		
			for(int j = i - 1;j > 0;j --) {	//去除首尾，从后往前遍历
				list.set(j, list.get(j - 1) + list.get(j));
			}
			list.add(1);	//末尾加1
			resList.add((ArrayList<Integer>)list.clone());
		}
		return resList;
    }
	
	public static void main(String[] args) {
		System.out.println(new PascalsTriangle().generate(3));
	}
}
