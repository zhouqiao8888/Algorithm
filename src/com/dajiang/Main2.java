package com.dajiang;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();	//n��
			int w = s.nextInt();	//��ʼ����
			Fenshi res = new Fenshi(0, 1);
			Fenshi suc = new Fenshi(0, 1);
			Fenshi failed = new Fenshi(0, 1);
			int res_z = 0;
			for(int i = 0;i < n;i ++) {
				int a = s.nextInt();	//����
				int b = s.nextInt();	//����
				int p = s.nextInt();	//�ɹ�����
				int q = s.nextInt();	//�ܱ���
				if((a * p) % q != 0) {
					suc = new Fenshi(a * p, q);
					res = res.sub(suc);
				}
				else {
					res_z = res_z - (a * p) / q;
				}
				if((b * (q - p)) % q != 0) {
					failed = new Fenshi(b * (q - p), q);
					res = res.add(failed);
				}
				else {
					res_z = res_z + (b * (q - p)) / q ;
				}
				
			}
			int temp = res.fz / res.fm;
			w = w + res_z + temp;
			res = new Fenshi(res.fz - temp * res.fm, res.fm);
			System.out.println(w + "+" + res);
		}
	}
}

class Fenshi {
	int fz;
	int fm;
	
	public Fenshi() {   //���캯��
	}
	
	public Fenshi(int fz, int fm) {
		this.fz = fz;
		this.fm = fm;
	}
	
	public Fenshi add(Fenshi fs) {
		int newfz = fz * fs.fm + fm * fs.fz;
		int newfm = fm * fs.fm;
		return new Fenshi(newfz, newfm);
	}
	
	public Fenshi sub(Fenshi fs) {
		int newfz = fz * fs.fm - fm * fs.fz;
		int newfm = fm * fs.fm;
		return new Fenshi(newfz, newfm);
	}
	
	public int gcd(int a, int b) {   //�����Լ��
		int m = Math.max(Math.abs(a), Math.abs(b));
		int n = Math.min(Math.abs(a), Math.abs(b));
		int r;
		while(n != 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	public String toString() {   //���������ʽ
		int g = gcd(fz, fm);
		if(fz % fm == 0) {
			return fz / fm+"";      //  +""  ��ʽת��Ϊ�ַ���,��Ϊ����ֵ��String���ͣ� ���Խ���ת��
		}
		else {
			return (fz / g) + "/" + (fm / g);
		}
	}
}

