package com.String;

import java.util.Stack;

/*
 * 简化路径名："/home/", =>"/home" "/a/./b/../../c/", =>"/c"
 * "/../" => "/"    "/home//foo/" => "/home/foo"
 * 规则：出现.直接去掉，出现..删除前一个元素，如果最后为空，返回"/"，出现"//"，忽略它
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if(path == null || path.length() <= 0)
			return path;
		String[] pathArr = path.split("/");
		Stack<String> stack = new Stack<String>();
		for(String str : pathArr) {
			if(!stack.isEmpty() && str.equals("..")) { //出现..删除前一个元素
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
