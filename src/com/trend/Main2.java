package com.trend;
//ɾ��ָ����������ʣ��Ԫ���������У�����������λ�ò�1(����Ҫ�����ռ�ⷨ)
import java.util.*;
public class Main2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();	//������
		for(int i = 0;i < T;i ++) {
			int N = s.nextInt();
			int[] arr = new int[N];
			for(int j = 0;j < N;j ++) {
				arr[j] = s.nextInt();
			}
			int X = s.nextInt();	//ɾ������
			//��Ԫ��ΪX����Ϊ1
			for(int j = 0;j < N;j ++) {
				if(arr[j] == X || arr[j] == 1) {
					arr[j] = 1;
				}
			}
			
			//�Ӻ���ǰ�����ҳ���һ����1��λ��
			int start = 0;
			for(int j = arr.length - 1;j >= 0;j --) {
				if(arr[j] == 1) {
					start = j;
					break;
				}
			}
			
			//�Ӻ���ǰ�������ƶ���1����
			for(int j = start + 1;j >= 0;j --) {
				if(arr[j] != 1) {
					int temp = arr[j];
					arr[j] = arr[start];
					arr[start] = temp;
					start --;
				}
			}
			
			//����
			for(int j = 0;j < N;j ++) {
				System.out.print(arr[j] + " ");
			}
			//System.out.println();
		}
	}
}
