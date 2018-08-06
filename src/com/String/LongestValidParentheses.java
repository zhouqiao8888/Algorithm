package com.String;

import java.util.Stack;

/*
 *寻找括号序列中有效的括号长度，例如给定")()())"，有效的括号序列为"()()"，有效长度为4
 *本题较难，注意分析，借助了栈
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if(s == null || s.length() < 2)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int last = -1; //左括号长度的起点
		int maxlen = 0;
		for(int i = 0;i < s.length();i ++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(i);	//不断压入左括号的下标
			}
			else {	//出现了右括号，要弹出左括号跟它匹配，但这时要注意栈是否为空
				if(stack.isEmpty()) { //栈为空，左括号不够用，出现了"())()"这种情况，更新起点
					last = i;
				}
				else {
					stack.pop();
					if(stack.isEmpty()) { //出现了类似"()()"这种情况，完全匹配，没有多余的左括号
						maxlen = Math.max(maxlen, i - last);
					}
					else { //出现了类似"()(()"这种情况，不完全匹配，存在多余的左括号
						maxlen = Math.max(maxlen, i - stack.peek());
					}
				}
			}
		}
		return maxlen;
	}
	
	public static void main(String[] args) {
		String s = "((()))";
		System.out.println(new LongestValidParentheses().longestValidParentheses(s));
	}
}
