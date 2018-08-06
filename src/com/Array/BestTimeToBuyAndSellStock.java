package com.Array;
//有某只股票价格数组（随天波动），若你只能买入卖出一次(最小买入，最大卖出)，找出最大收益
public class BestTimeToBuyAndSellStock {
	 public int maxProfit(int[] prices) {
		 if(prices == null || prices.length == 0)
             return 0;
		 int res = 0;
		 int min = prices[0];	//保存当前最小的进价
		 for(int i = 1;i < prices.length;i ++) {
			 if(prices[i] < min){
				 min = prices[i];
			 }
			 if(prices[i] - min > res) { //假设在第i天卖出，若卖出收益高于记录的最大收益，则更新最大收益
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
