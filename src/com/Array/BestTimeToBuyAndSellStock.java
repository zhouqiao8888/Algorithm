package com.Array;
//��ĳֻ��Ʊ�۸����飨���첨����������ֻ����������һ��(��С���룬�������)���ҳ��������
public class BestTimeToBuyAndSellStock {
	 public int maxProfit(int[] prices) {
		 if(prices == null || prices.length == 0)
             return 0;
		 int res = 0;
		 int min = prices[0];	//���浱ǰ��С�Ľ���
		 for(int i = 1;i < prices.length;i ++) {
			 if(prices[i] < min){
				 min = prices[i];
			 }
			 if(prices[i] - min > res) { //�����ڵ�i��������������������ڼ�¼��������棬������������
				 res = prices[i] - min;
			 }
		 }
		 return res;
	 }
	 
	 public static void main(String[] args) {
		 int[] prices = {2,1,3,43};
		 System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
	 }
}
