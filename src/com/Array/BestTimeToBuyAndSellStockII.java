package com.Array;
//��ĳֻ��Ʊ�۸����飨���첨�����������ܶ����������(��С���룬�������)���ҳ��������
//˼·����¼���������ķ��ȼ���
public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
            return 0;
		int max = 0;
		for(int i = 0;i < prices.length - 1;i ++) {
			if(prices[i + 1] - prices[i] > 0) {
				max += prices[i + 1] - prices[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] prices = {2,1,3,43};
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
	}
}
