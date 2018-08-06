package com.zhaoshangbank;
/*将一个正整数分解成至少两个正整数的和，使得这多个数的乘积最大
 *10可拆成1+9，2+8，3+7,4+6,5+5
 *对于其中一项可分成4种情况，拆3拆7，不拆3不拆7，拆3不拆7，不拆3拆7
 */
public class IntegerBreak {
	public int getResult(int n) {
		if(n == 1)	return 0;
		if(n == 2)	return 1;
		int[] dp = new int[n + 1];
		dp[0] = 0;	//用不到，无所谓
		dp[1] = 1;	//方便乘法
		dp[2] = 1;
		
		for(int i = 3;i <= n;i ++) {	//求dp里的每一项
			int max = 0;
			for(int j = 1;j <= i / 2;j ++) {
				int temp1 = Math.max(dp[j] * dp[i - j], j * (i - j));	//都拆，都不拆
				int temp2 = Math.max(dp[j] * (i - j), j * dp[i - j]);	//拆一个
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
