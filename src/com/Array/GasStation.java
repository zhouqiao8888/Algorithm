package com.Array;
/*
 *N������վ����һ������ÿ������վ�ɼ�gas[i]�ͣ�
 *�����ɼ������������Ҵӵ�i������վ����i+1������վ����cost[i]��
 *�ʼ����û�ͣ���������һ������վ����
 *���������������һȦ��������ʼ����վ���±꣬������ܣ�����-1���𰸵Ľ���Ψһ��
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || cost == null)
			return -1;
		for(int i = 0;i < gas.length;i ++) {
			int j = i;
			int sum = 0;
			for(;j < gas.length;j ++) {
				sum += gas[j];	//����
				if(sum < cost[j]) {
					break;
				}		
				sum -= cost[j];
			}
			if(j == gas.length) {	//�ߵ�ͷ�ˣ��ٿ�ʼ��0��ʼ��
				//System.out.println("i:" + i + " sum:" + sum);
				j = 0;	
				while(j < i) {
					sum += gas[j];	//����
					if(sum < cost[j]) {
						break;
					}
					sum -= cost[j];
					j ++;
				}
				if(j == i) {	//����һȦ
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
