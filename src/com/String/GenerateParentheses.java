package com.String;

import java.util.ArrayList;

/*
 * 给定一个n，产生对数为n的有效括号集合，例如n=3
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
	//left表示当前左括号的数量，right表示当前右括号的数量
	public void generate(int n, int left, int right, ArrayList<String> res, String str) { 
		if(right == n) { //当右括号的数量都等于n时，说明所有的括号都已经添加完成了
			res.add(str);
		}		
		if(left < n) {
			generate(n, left + 1, right, res, str + "(");
		}
		if(left > right) {	//只有当左括号的数量大于右括号的数量时，才能添加右括号
			generate(n, left, right + 1, res, str + ")");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis(3));
	}
}
