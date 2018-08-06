package com.webank;
/*有限域问题：
 *在n的范围内，某一个数是素数或者是素数的k次方(素数的k次方不一定还是素数)，
 *则认为满足要求，求满足这样的数的个数。例如当n=37时，满足要求的数共19个：
 *2，3，4，5，7，8，9，11，13，16，17，19，23，25，27，29，31，32，37。
*/
import java.util.Scanner;
public class FiniteField {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int flag[] = new int[n + 1];	//标识数组，如果某一个数已经判断过是素数了，则下次不用再判断
			int count = 0;
			for(int j = 2; j <= n; j ++){
				if(flag[j] == 1) 
					continue;
				if(isPrime(j)){
					flag[j] = 1;
					count ++;
					int base = j;
					while(base * j <= n){	//质数的k次方也是满足要求的
						base = base * j;
						flag[base] = 1;
						count ++;
					}
				}
			}
			System.out.println(count);
		}
	}
	//判断一个数是否是素数
	public static boolean isPrime(int number){  
	    if(number == 2) 
	    	return true;
	    if(number < 2 || number % 2 == 0) //偶数肯定不是素数(除了2),奇数不一定是素数(例如9),素数肯定是3,5,7,,
	    	return false; 		
	    for(int j = 3;j <= Math.sqrt(number);j += 2){ //该数已经不是2的倍数了,更不可能是4,6,8,,的倍数,所以j += 2 
	        if(number % j == 0){
	            return false;  
	        }  
	    }  
	    return true;  
	}  
}

