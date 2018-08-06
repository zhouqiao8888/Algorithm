package com.huawei_spring;
import java.util.*;
/*
 * 给出一组正整数，你从第一个数向最后一个数方向跳跃，每次至少跳跃1格，
 * 每个数的值表示你从这个位置可以跳跃的最大长度。计算如何以最少的跳跃次数跳到最后一个数。  
 */
public class JumpGame{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
	        int len = s.nextInt();
	        int A[] = new int[len];
	        for(int j = 0; j < len; j ++){
	            A[j] = s.nextInt();
	        }
	        int i = 0;
	        int count = 0;
	        while(i < len - 1) {  
	        	count ++;
	        	int p1 = i + 1;		//当前可跳跃的起点
	        	int p2 = i + A[i];	//当前可跳跃的终点
	        	if(p2 >= len - 1)	//终点超出了数组长度，直接跳出循环
	        		break;    
	        	//寻找区间范围内可跳最远距离的元素下标
	    		int max = p1 + A[p1];
	    		int maxIndex = p1;
	    		for(int j = p1 + 1;j <= p2 && j < len;j ++) {
	    			int temp = j + A[j];
	    			if(temp > max) {
	    				max = temp;
	    				maxIndex = j;
	    			}
	    		}
	    		i = maxIndex;
	        }
	        System.out.println(count);
        }
    }
}

