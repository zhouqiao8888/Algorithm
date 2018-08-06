package com.Array;
/*
 * ���������0ȫ���ƶ���ĩβ
 * ��������[0, 1, 0, 3, 12], �ƶ���Ľ����[1, 3, 12, 0, 0]. 
 */
public class MoveZeros {
	//��һ������һ������Ԫ�ص�ָ��,ֻ��ע����
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
	
	//����������һ����ʼ0��ָ�룬����һ������0��ָ�룬�ô��ǿ��Եõ���һ�γ���0��λ�ú����һ�γ���0��λ��
	public void move2(int[] array) {
		int start = 0;
		int end = 0;
		int i = 0;
		//�ҳ�0��һ�γ��ֵ�λ��
		for(;i < array.length;i ++) {
			if(array[i] == 0) {
				start = i;
				end = i;
				break;
			}
		}
		
		//��֤start��end��λ���ǲ���0
		if(array[end] != 0)
			return;
		
		//����0
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
