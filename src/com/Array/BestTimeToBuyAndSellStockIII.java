package com.Array;
//有某只股票价格数组（随天波动），若你能两次买入卖出，找出最大收益
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
            return 0;
		int buy1 = Integer.MIN_VALUE;
		int sell1 = 0;
		int buy2 = Integer.MIN_VALUE;
		int sell2 = 0;
		for(int i = 0;i < prices.length;i ++) {
			buy1 = Math.max(-prices[i], buy1);	//负数越大，买入的价格最低
			sell1 = Math.max(buy1 + prices[i], sell1);	//如果当前卖出收益大于先前收益，则更新先前最大收益
			buy2 = Math.max(-prices[i] + sell1, buy2);	//第二次买入时的价格为当前价格减去第一次交易的收入
			sell2 = Math.max(buy2 + prices[i], sell2);  //如果第二次卖出收益大于先前收益，则更新第二次最大收益
		}
		return sell2;
	}
	
	public static void main(String[] args) {
		int[] prices = {2,1,3,41};
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
	}
}
