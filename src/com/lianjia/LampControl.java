package com.lianjia;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * ��n�����أ�ÿ�����ؿɿ������ɸ����ݣ��������ɿ��ƶ��ٸ�����
 * ע��ÿ�����ؿ��Ƶĵ��ݻ����ظ�������Set����Ȼȥ��
 */
public class LampControl {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();	//n�鿪��
		Set<Integer> set = new HashSet<Integer>();	//�洢�������
		int[] k = new int[n];	//�洢���ؿ��Ƶĵ��ݸ���
		for(int i = 0;i < n;i ++) {
			k[i] = s.nextInt();
			for(int j = 0;j < k[i];j ++) {
				set.add(s.nextInt());
			}
		}		
		System.out.println(set.size());
	}
}
