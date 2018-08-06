package com.Array;
/*
 *实现“下一个排列”函数，将排列中的数字重新排列成字典序中的下一个更大的排列。 
 *如果这样的重新排列是不可能的，它必须重新排列为可能的最低顺序(即升序排序).例如
 1,2,3→1,3,2
 3,2,1→1,2,3
 1,1,5→1,5,1 
 */
import java.util.*;
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if(num == null || num.length <= 1)
			return;
		//从后往前找，找到第一个num[pos]>num[pos - 1]的位置
		int pos = num.length - 1;
		for(;pos > 0;pos --) {
			if(num[pos] > num[pos - 1])
				break;
		}
		if(pos == 0) { //没找到这样的升序点，说明原序列降序，则直接升序排列返回
			Arrays.sort(num);
			return;
		}
		
		//从pos开始，将后面的数据变成升序排列，寻找第一个比pos-1位置数大的数据，并交换
		Arrays.sort(num, pos, num.length);
		for(int i = pos;i < num.length;i ++) {
			if(num[i] > num[pos - 1]) {
				int temp = num[pos - 1];
				num[pos - 1] = num[i];
				num[i] = temp;
				return;
			}
		}
	}
	 
	public static void main(String[] args) {
		int[] num = {1,3,2,23,7,10,9,8};
		new NextPermutation().nextPermutation(num);
		for(int i = 0;i < num.length;i ++) {
			System.out.print(num[i] + " ");
		}
	}
}
