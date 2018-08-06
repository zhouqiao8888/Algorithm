package com.Array;
/*
 *N个加油站构成一个环，每个加油站可加gas[i]油，
 *卡车可加任意升的油且从第i个加油站到第i+1个加油站消耗cost[i]油
 *最开始卡车没油，可在任意一个加油站加油
 *如果卡车可以走完一圈，返回起始加油站的下标，如果不能，返回-1，答案的解是唯一的
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || cost == null)
			return -1;
		for(int i = 0;i < gas.length;i ++) {
			int j = i;
			int sum = 0;
			for(;j < gas.length;j ++) {
				sum += gas[j];	//加油
				if(sum < cost[j]) {
					break;
				}		
				sum -= cost[j];
			}
			if(j == gas.length) {	//走到头了，再开始从0开始走
				//System.out.println("i:" + i + " sum:" + sum);
				j = 0;	
				while(j < i) {
					sum += gas[j];	//加油
					if(sum < cost[j]) {
						break;
					}
					sum -= cost[j];
					j ++;
				}
				if(j == i) {	//走完一圈
					return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		GasStation gs = new GasStation();
		int index = gs.canCompleteCircuit(gas, cost);
		System.out.println(index);
	}
}
