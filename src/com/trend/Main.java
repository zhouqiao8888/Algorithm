package com.trend;
//ɾ��ָ����������ʣ��Ԫ���������У�����������λ�ò�1(���������ռ�ⷨ)
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();	//������
		for(int i = 0;i < T;i ++) {
			int N = s.nextInt();
			int[] arr = new int[N];
			for(int j = 0;j < N;j ++) {
				arr[j] = s.nextInt();
			}
			int X = s.nextInt();
			//��Ԫ��ΪX����Ϊ1,��ͳ��1�ĸ���
			List<Integer> list = new ArrayList<Integer>();
			int count = 0;
			for(int j = 0;j < N;j ++) {
				if(arr[j] == X || arr[j] == 1) {
					arr[j] = 1;
					count ++;
				}
				else {
					list.add(arr[j]);
				}
			}
			
			for(int j = 0;j < count;j ++) {
				arr[j] = 1;
			}
			
			int k = 0;
			for(int j = count;j < arr.length;j ++) {
				arr[j] = list.get(k ++);
			}
			
			//����
			for(int j = 0;j < N;j ++) {
				System.out.print(arr[j] + " ");
			}
		}
	}
}
