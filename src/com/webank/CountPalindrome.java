package com.webank;
/*
 *����һ����n,��һ��������Ҫ��С��n���Ҷ�������ʽ�ǻ��Ĵ���
 *ͳ�����������ĸ���
 */
import java.util.Scanner;
public class CountPalindrome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			Long n = s.nextLong();
			long count = 0;
			for(int i = 0;i < n;i ++) {
				if(i != 0 && i % 2 == 0) {	//ż���Ķ�������ʽ�϶����ǻ��Ĵ�
					continue;
				}
				String str = Integer.toBinaryString(i);
				if(isMatch(str)) {
					count ++;
					System.out.println(i + " " + str + " ");
				}
			}
			System.out.println(count);
		}		
	}	
	//�ж��Ƿ��ǻ��Ĵ�
	public static boolean isMatch(String str) {
		int i = 0;
		int j = str.length() - 1;
		for(;i < str.length() / 2;i ++) {
			if(str.charAt(i) == str.charAt(j)) {
				j --;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
}

