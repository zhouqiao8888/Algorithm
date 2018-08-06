package com.Array;
/*
 * 将数组里的0全部移动到末尾
 * 例：给定[0, 1, 0, 3, 12], 移动后的结果是[1, 3, 12, 0, 0]. 
 */
public class MoveZeros {
	//法一：定义一个非零元素的指针,只关注非零
	public void move(int[] array) {
		int feiling = 0;
		for(int i = 0;i < array.length;i ++) {
			if(array[i] != 0) {
				array[feiling] = array[i];
				feiling ++;
			}
		}
		
		for(int j = feiling;j < array.length;j ++) {
			array[j] = 0;
		}
	}
	
	//法二：定义一个开始0的指针，定义一个结束0的指针，好处是可以得到第一次出现0的位置和最后一次出现0的位置
	public void move2(int[] array) {
		int start = 0;
		int end = 0;
		int i = 0;
		//找出0第一次出现的位置
		for(;i < array.length;i ++) {
			if(array[i] == 0) {
				start = i;
				end = i;
				break;
			}
		}
		
		//验证start和end的位置是不是0
		if(array[end] != 0)
			return;
		
		//调整0
		for(int j = i + 1;j < array.length;j ++) {
			if(array[j] == 0)
				end ++;
			else {
				array[start] = array[j];
				array[j] = 0;
				start ++;
				end ++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 0, 3, 12};
		MoveZeros mz = new MoveZeros();
		mz.move2(array);
		for(int i = 0;i < array.length;i ++) {
			System.out.print(array[i] + " ");
		}
	}
}
