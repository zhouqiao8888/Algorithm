package com.Array;

import java.util.*;

/*��˹�����ǣ�����һ���������һ�����⣬�м������һ���������ڶ������������ۼ�
 ���磺����rowIndex = 4��������£�Ҫ��ռ临�Ӷ�ΪO(n)
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
		for(int i = 0;i < numRows;i ++) {	 //ѭ������		
			for(int j = i - 1;j > 0;j --) {	//ȥ����β���Ӻ���ǰ����
				list.set(j, list.get(j - 1) + list.get(j));
			}
			list.add(1);	//ĩβ��1
			resList.add((ArrayList<Integer>)list.clone());
		}
		return resList;
    }
	
	public static void main(String[] args) {
		System.out.println(new PascalsTriangle().generate(3));
	}
}
