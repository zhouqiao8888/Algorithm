package com.lianjia;
import java.util.*;
/*
 * n��ľ������i��ľ��������i,��������ȥ������ľ������ʹʣ�µ�ľ�����ܹ���һ�������Ρ�
 * ˼·����������֮�ʹ��ڵ����ߣ����Թ��������ε����������Ҫ��ȥ���������
 * ���ߣ���Ϊ��������С�ڵ���n��쳲���������(���ܹ��������ε�1,2,3,5,8),
 * �������������С�ڵ���n��쳲��������У�Ȼ����n-���еĳ��ȣ�������Ҫȥ����ľ��������
 */
public class StickProblem {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();
			int x1 = 2;
			int x2 = 3;
			int result = 0;
			for(int i = 4;i <= n;i ++) {
				if(i < x1 + x2) {	//����֮�ʹ��ڵ����ߣ����Թ��������ε��������ȥ��ľ�������
					result ++;
					//System.out.println("x1: "+x1+" x2: "+x2);
				}
				else {
					x1 = x2;
					x2 = i;
				}
			}
			System.out.println(result);
//			StickProblem sp = new StickProblem();
//			System.out.println(sp.getCount(n));
			x1 = 2;
			x2 = 3;
			result = 0;
		}		
	}
	
	public int getCount(int n) {	//��������С�ڵ���n��쳲���������(���ܹ��������ε�)
		if(n == 1 || n == 2 || n == 3)
			return 0;
		int x1 = 2;
		int x2 = 3;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		while(x1 + x2 <= n) {
			int x = x1 + x2;
			list.add(x);
			x1 = x2;
			x2 = x;
		}
		//System.out.println(list);
		return n - list.size();
	}
}
