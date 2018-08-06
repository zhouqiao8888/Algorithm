package com.String;

import java.util.ArrayList;

/*
 * ����һ��n����������Ϊn����Ч���ż��ϣ�����n=3
 * "((()))", "(()())", "(())()", "()(())", "()()()" 
 */
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if(n <= 0)
			return res;
		generate(n, 0, 0, res, new String());
		return res;
	}
	//left��ʾ��ǰ�����ŵ�������right��ʾ��ǰ�����ŵ�����
	public void generate(int n, int left, int right, ArrayList<String> res, String str) { 
		if(right == n) { //�������ŵ�����������nʱ��˵�����е����Ŷ��Ѿ���������
			res.add(str);
		}		
		if(left < n) {
			generate(n, left + 1, right, res, str + "(");
		}
		if(left > right) {	//ֻ�е������ŵ��������������ŵ�����ʱ���������������
			generate(n, left, right + 1, res, str + ")");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis(3));
	}
}
