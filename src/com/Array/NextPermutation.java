package com.Array;
/*
 *ʵ�֡���һ�����С��������������е������������г��ֵ����е���һ����������С� 
 *������������������ǲ����ܵģ���������������Ϊ���ܵ����˳��(����������).����
 1,2,3��1,3,2
 3,2,1��1,2,3
 1,1,5��1,5,1 
 */
import java.util.*;
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if(num == null || num.length <= 1)
			return;
		//�Ӻ���ǰ�ң��ҵ���һ��num[pos]>num[pos - 1]��λ��
		int pos = num.length - 1;
		for(;pos > 0;pos --) {
			if(num[pos] > num[pos - 1])
				break;
		}
		if(pos == 0) { //û�ҵ�����������㣬˵��ԭ���н�����ֱ���������з���
			Arrays.sort(num);
			return;
		}
		
		//��pos��ʼ������������ݱ���������У�Ѱ�ҵ�һ����pos-1λ����������ݣ�������
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
