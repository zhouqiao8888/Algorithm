package com.Array;
import java.util.ArrayList;
/*帕斯卡三角：除第一个数和最后一个数外，中间的任意一个数都等于顶上两个数的累加
 例如：输入rowIndex = 3，输出1 3 3 1，要求空间复杂度为O(n)
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
		for(int i = 0;i <= rowIndex;i ++) { //循环次数,也是层数
			for(int j = i - 1;j > 0;j --) {	//去除首尾，从后往前遍历
				list.set(j, list.get(j - 1) + list.get(j));
			}
			list.add(1); //每次循环结束，都要在末尾添加一个1扩容
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(new PascalsTriangleII().getRow(10));
	}
}
