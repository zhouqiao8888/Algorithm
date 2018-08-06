package com.dajiang;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();	//n天
			int w = s.nextInt();	//初始体重
			Fenshi res = new Fenshi(0, 1);
			Fenshi suc = new Fenshi(0, 1);
			Fenshi failed = new Fenshi(0, 1);
			int res_z = 0;
			for(int i = 0;i < n;i ++) {
				int a = s.nextInt();	//减重
				int b = s.nextInt();	//增重
				int p = s.nextInt();	//成功比重
				int q = s.nextInt();	//总比重
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
	
	public Fenshi() {   //构造函数
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
	
	public int gcd(int a, int b) {   //求最大公约数
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
	
	public String toString() {   //定义输出格式
		int g = gcd(fz, fm);
		if(fz % fm == 0) {
			return fz / fm+"";      //  +""  隐式转换为字符串,因为返回值是String类型， 所以进行转换
		}
		else {
			return (fz / g) + "/" + (fm / g);
		}
	}
}

