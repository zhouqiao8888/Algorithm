package com.Array;
/*
 * 给定一个非负数组，数组中的每个元素表示该元素可以跳跃的最大长度，
 * 求跳跃到数组最后一个元素所需的最小步数。不存在0的情况，保证是可以跳跃的
 * 例如：给定数组A = [2,3,1,1,4]，最小步数是2
 * 思路：第一个节点必须要进入，每次进入一个起点i之后，
 * 下一步的落点可以是[i+1, i+nums[i]]，找到这个范围内的可以跳跃最远的点作为下一步。
 * 循环直到跳跃到最后。
 * 注意：跳跃最远与两个因素有关：起点和跳跃的长度
 */
public class JumpGameII {
	public int jump(int[] A) {
        if(A.length <= 0 || A == null)
        	return 0;
        int i = 0;
        int count = 0;
        int len = A.length;
        while(i < len - 1) {  
        	count ++;
        	int p1 = i + 1;
        	int p2 = i + A[i];
        	if(p2 >= len - 1)	//最大的跳跃范围超出了数组长度，直接跳出循环
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
        return count;
    }
	
	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		int[] A = {2,3,1,1,4};
		System.out.println(jg.jump(A));
	}

}
