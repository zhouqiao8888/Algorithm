package com.String;

import java.util.Stack;

/*
 *Ѱ��������������Ч�����ų��ȣ��������")()())"����Ч����������Ϊ"()()"����Ч����Ϊ4
 *������ѣ�ע�������������ջ
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if(s == null || s.length() < 2)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int last = -1; //�����ų��ȵ����
		int maxlen = 0;
		for(int i = 0;i < s.length();i ++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(i);	//����ѹ�������ŵ��±�
			}
			else {	//�����������ţ�Ҫ���������Ÿ���ƥ�䣬����ʱҪע��ջ�Ƿ�Ϊ��
				if(stack.isEmpty()) { //ջΪ�գ������Ų����ã�������"())()"����������������
					last = i;
				}
				else {
					stack.pop();
					if(stack.isEmpty()) { //����������"()()"�����������ȫƥ�䣬û�ж����������
						maxlen = Math.max(maxlen, i - last);
					}
					else { //����������"()(()"�������������ȫƥ�䣬���ڶ����������
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
