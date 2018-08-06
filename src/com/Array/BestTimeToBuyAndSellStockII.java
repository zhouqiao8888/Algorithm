package com.Array;
//有某只股票价格数组（随天波动），若你能多次买入卖出(最小买入，最大卖出)，找出最大收益
//思路：记录连续增长的幅度即可
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
