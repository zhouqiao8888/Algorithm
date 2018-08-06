package com.String;

import java.util.Stack;

/*
 * ��·������"/home/", =>"/home" "/a/./b/../../c/", =>"/c"
 * "/../" => "/"    "/home//foo/" => "/home/foo"
 * ���򣺳���.ֱ��ȥ��������..ɾ��ǰһ��Ԫ�أ�������Ϊ�գ�����"/"������"//"��������
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if(path == null || path.length() <= 0)
			return path;
		String[] pathArr = path.split("/");
		Stack<String> stack = new Stack<String>();
		for(String str : pathArr) {
			if(!stack.isEmpty() && str.equals("..")) { //����..ɾ��ǰһ��Ԫ��
				stack.pop();
			}
			else if(!str.equals(".") && !str.equals("..") && !str.equals("")) {
				stack.push(str);
			}
		}
			
		if(stack.isEmpty())
			return "/";
		String res = new String();
		while(!stack.isEmpty()) {
			res = "/" + stack.pop() + res;
		}
		return res;
	}	
	
	public static void main(String[] args) {
		String path = "/home//foo/";
		System.out.println(new SimplifyPath().simplifyPath(path));
	}
}
