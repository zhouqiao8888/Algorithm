package com.Array;

import java.util.Arrays;

/*N个孩子站成一排，每个孩子分配一个分值。给这些孩子派发糖果，满足如下要求：
 每个孩子至少一个,分值更高的孩子比他的相邻位的孩子获得更多的糖果
 求至少分发多少糖果？
 */
public class Candy {
	public int candy(int[] ratings) {
		if(ratings == null)
			return 0;
		int count[] = new int[ratings.length];
		Arrays.fill(count, 1); //每个孩子最少一个糖果
		//正向遍历，保证后面分值大的人分的糖果更多
		for(int i = 1;i < count.length;i ++) {
			if(ratings[i] > ratings[i - 1]) {
				count[i] = count[i - 1] + 1;
			}
		}
		//反向遍历，保证前面分值大的人分的糖果更多
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
