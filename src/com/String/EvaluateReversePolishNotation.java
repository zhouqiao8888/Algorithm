package com.String;
import java.util.Stack;
/*
 *计算逆波兰式的结果
 *["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if(tokens.length <= 0 || tokens == null)
        	return 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0;i < tokens.length;i ++) {
        	if(tokens[i].equals("+") || tokens[i].equals("-") 
        	  || tokens[i].equals("*") || tokens[i].equals("/")) {
        		int b = s.pop();
        		int a = s.pop();
        		addElement(s, a, b, tokens[i]);
        	}
        	else {
        		s.push(Integer.parseInt(tokens[i]));
        	}
        }
        return s.pop();
    }
		
	public void addElement(Stack<Integer> s, int a, int b, String flag) {
		if(flag.equals("+")) {
			s.push(a + b);
		}
		if(flag.equals("-")) {
			s.push(a - b);
		}
		if(flag.equals("*")) {
			s.push(a * b);
		}
		if(flag.equals("/")) {
			s.push(a / b);
		}
	}
	
	public static void main(String[] args) {
		String[] tokens = {"0","3","/"};
		System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
	}
}
