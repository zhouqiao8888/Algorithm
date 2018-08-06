package com.zhaoshangbank;
/*��һ���������ֽ�����������������ĺͣ�ʹ���������ĳ˻����
 *10�ɲ��1+9��2+8��3+7,4+6,5+5
 *��������һ��ɷֳ�4���������3��7������3����7����3����7������3��7
 */
public class IntegerBreak {
	public int getResult(int n) {
		if(n == 1)	return 0;
		if(n == 2)	return 1;
		int[] dp = new int[n + 1];
		dp[0] = 0;	//�ò���������ν
		dp[1] = 1;	//����˷�
		dp[2] = 1;
		
		for(int i = 3;i <= n;i ++) {	//��dp���ÿһ��
			int max = 0;
			for(int j = 1;j <= i / 2;j ++) {
				int temp1 = Math.max(dp[j] * dp[i - j], j * (i - j));	//���𣬶�����
				int temp2 = Math.max(dp[j] * (i - j), j * dp[i - j]);	//��һ��
				int temp = Math.max(temp1, temp2);
				max = Math.max(temp, max);
			}
			dp[i] = max;
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		IntegerBreak ib = new IntegerBreak();
		System.out.println(ib.getResult(3));
	}
}
