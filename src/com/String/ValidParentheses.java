package com.String;

import java.util.Stack;

/*
 * �ж�ĳ���ַ����ǲ�����Ч����������(�������ַ�'(',')','{','}','['and']')
 * ����,"()"and"()[]{}"are all valid 
 * but"(]"and"([)]"are not. 
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if(s == null || s.length() <= 0)
			return true;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i < s.length();i ++) {
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				if(stack.isEmpty()) {	//��������Ӧ�����ţ�����ջ���ˣ�ֱ�ӷ���false
					return false;
				}
				else {
					if(c == ')' && stack.peek() != '(') {
						return false;
					}
					if(c == ']' && stack.peek() != '[') {
						return false;
					}
					if(c == '}' && stack.peek() != '{') {
						return false;
					}
					stack.pop();	//�ַ����ַ���ջ���ַ���ƥ���
				}
			}			
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("))"));
	}
}
