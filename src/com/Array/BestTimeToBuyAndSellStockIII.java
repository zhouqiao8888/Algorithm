package com.Array;
//��ĳֻ��Ʊ�۸����飨���첨���������������������������ҳ��������
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
            return 0;
		int buy1 = Integer.MIN_VALUE;
		int sell1 = 0;
		int buy2 = Integer.MIN_VALUE;
		int sell2 = 0;
		for(int i = 0;i < prices.length;i ++) {
			buy1 = Math.max(-prices[i], buy1);	//����Խ������ļ۸����
			sell1 = Math.max(buy1 + prices[i], sell1);	//�����ǰ�������������ǰ���棬�������ǰ�������
			buy2 = Math.max(-prices[i] + sell1, buy2);	//�ڶ�������ʱ�ļ۸�Ϊ��ǰ�۸��ȥ��һ�ν��׵�����
			sell2 = Math.max(buy2 + prices[i], sell2);  //����ڶ����������������ǰ���棬����µڶ����������
		}
		return sell2;
	}
	
	public static void main(String[] args) {
		int[] prices = {2,1,3,41};
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
	}
}
