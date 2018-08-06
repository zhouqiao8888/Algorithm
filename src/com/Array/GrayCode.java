package com.Array;
/*给定n，返回n位格雷码序列。例如：n=2,返回[0(00), 1(01), 3(11), 2(10)]
 *n=0 返回 0
 *n=1 返回 0 1
 *n=2 返回 0 1 3 2
 *n=3 返回 0 1 3 2 6 7 5 4
 *观察规律：3=1+2,2=0+2; 6=2+4,7=3+4
 */
import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		if(n == 0)
			return list;
		list.add(1);
		if(n == 1)
			return list;
		for(int i = 1;i < n;i ++) { //循环次数
			int size = list.size();
			int increase = (int)Math.pow(2, i); //增量
			for(int j = size - 1;j >= 0;j --) {
				list.add(list.get(j) + increase);
			}
		}
		return list;
    }
	
	public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(3));
	}
}
