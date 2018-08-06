package com.String;

import java.util.Stack;

/*
 * 判断某个字符串是不是有效的括号序列(仅包含字符'(',')','{','}','['and']')
 * 例如,"()"and"()[]{}"are all valid 
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
				if(stack.isEmpty()) {	//出现了相应右括号，但是栈空了，直接返回false
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
					stack.pop();	//字符串字符和栈顶字符是匹配的
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
