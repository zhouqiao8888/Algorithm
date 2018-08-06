package com.Array;

import java.util.Arrays;

/*N������վ��һ�ţ�ÿ�����ӷ���һ����ֵ������Щ�����ɷ��ǹ�����������Ҫ��
 ÿ����������һ��,��ֵ���ߵĺ��ӱ���������λ�ĺ��ӻ�ø�����ǹ�
 �����ٷַ������ǹ���
 */
public class Candy {
	public int candy(int[] ratings) {
		if(ratings == null)
			return 0;
		int count[] = new int[ratings.length];
		Arrays.fill(count, 1); //ÿ����������һ���ǹ�
		//�����������֤�����ֵ����˷ֵ��ǹ�����
		for(int i = 1;i < count.length;i ++) {
			if(ratings[i] > ratings[i - 1]) {
				count[i] = count[i - 1] + 1;
			}
		}
		//�����������֤ǰ���ֵ����˷ֵ��ǹ�����
		int sum = 0;
		for(int i = count.length - 1;i > 0;i --) {
			if(ratings[i] < ratings[i - 1] && count[i] >= count[i - 1]) {
				count[i - 1] = count[i] + 1; 
			}
			sum += count[i];
		}
		sum += count[0];
		return sum;
	}
	 
	public static void main(String[] args) {
		int[] ratings = {1,2,4,4,5};
		System.out.println(new Candy().candy(ratings));
	}
}
