package com.Array;
import java.util.ArrayList;
/*��˹�����ǣ�����һ���������һ�����⣬�м������һ���������ڶ������������ۼ�
 ���磺����rowIndex = 3�����1 3 3 1��Ҫ��ռ临�Ӷ�ΪO(n)
 *  1
 * 1 1
 *1 2 1
 1 3 3 1
 */
public class PascalsTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(rowIndex < 0)
			return list;
		for(int i = 0;i <= rowIndex;i ++) { //ѭ������,Ҳ�ǲ���
			for(int j = i - 1;j > 0;j --) {	//ȥ����β���Ӻ���ǰ����
				list.set(j, list.get(j - 1) + list.get(j));
			}
			list.add(1); //ÿ��ѭ����������Ҫ��ĩβ���һ��1����
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(new PascalsTriangleII().getRow(10));
	}
}
