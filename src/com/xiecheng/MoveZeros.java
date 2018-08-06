package com.xiecheng;
/*将数组中的数全部移动到末尾
 *比如[0,1,0,3,12]移动后的期望数组为[1,3,12,0,0]
 */
public class MoveZeros {
	public static void moveZeros(int[] nums) {
		//找到第一个0开始的位置
		int start = -1;
		for(int i = 0;i < nums.length;i ++) {
			if(nums[i] == 0) {
				start = i;
				break;
			}
		}
		if(start == -1) { //不存在0
			return;
		}
		else {
			for(int j = start + 1;j < nums.length;j ++) {
				if(nums[j] != 0) {	//不为0就交换，同时start指针右移
					int temp = nums[j];
					nums[j] = nums[start];
					nums[start] = temp;
					start ++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {11,0,1,0,23,0,12};
		MoveZeros.moveZeros(nums);
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}
}
