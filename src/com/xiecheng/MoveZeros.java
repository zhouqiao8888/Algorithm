package com.xiecheng;
/*�������е���ȫ���ƶ���ĩβ
 *����[0,1,0,3,12]�ƶ������������Ϊ[1,3,12,0,0]
 */
public class MoveZeros {
	public static void moveZeros(int[] nums) {
		//�ҵ���һ��0��ʼ��λ��
		int start = -1;
		for(int i = 0;i < nums.length;i ++) {
			if(nums[i] == 0) {
				start = i;
				break;
			}
		}
		if(start == -1) { //������0
			return;
		}
		else {
			for(int j = start + 1;j < nums.length;j ++) {
				if(nums[j] != 0) {	//��Ϊ0�ͽ�����ͬʱstartָ������
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
