package com.String;
/*
 * ����һ���ַ��������������п��ܵĻ��Ĵ�
 * ���磬����aab,������a,a,b;aa,b
 */
import java.util.*;
public class PalindromePartitioning {
	ArrayList<ArrayList<String>>  res = new ArrayList<ArrayList<String>>();
	ArrayList<String> temp = new ArrayList<String>();
	public ArrayList<ArrayList<String>> partition(String s) {
		getRes(s, 0);
		return res;
	}
	
	public void getRes(String s, int left) {
		if(temp != null && left >= s.length()) {	//ָ�뵽ͷ����������
			res.add(new ArrayList<String>(temp));
		}
		for(int right = left;right < s.length();right ++) {
			String str = s.substring(left, right + 1);
			if(isPalindrome(str)) {	//�ǻ��Ĵ�������temp��Ȼ���жϺ�����ǲ��ǻ��Ĵ�
				temp.add(str);
				getRes(s, right + 1);
				temp.remove(temp.size() - 1);	//������һ�����Ƴ�ĩβԪ��(��abbbΪ��)
			}
		}
	}
	
	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		for(;i < s.length() / 2;i ++) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			j --;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		String s = "abbb";
		pp.partition(s);
		System.out.println(pp.res);
	}
}
