package com.Array;

import java.util.ArrayList;

/*
 * ����һ���ַ���S��һ���ַ�������L��L�е��ַ������ȶ���ȣ�
 * �ҳ�S�����е��Ӵ�ǡ�ð���L�������ַ���һ�Σ������Ӵ���λ�ã�����
 * S:"barfoothefoobarman"
   L:["foo", "bar"] 
  �ҵ�"barfoo"��"foobar",����:[0,9].
 */
public class SubstringWithConcatenationOfAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(S == null || S.length() <= 0 
		  || L == null || L.length <= 0 || S.length() < L[0].length() * L.length)
			return res;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0;i < L.length;i ++) { 
			list.add(L[i]);
		}
		int len = L[0].length();
		for(int i = 0;i <= S.length() - len;i ++) {
			ArrayList<String> temp = new ArrayList<String>(list);
			String subStr = S.substring(i, i + len);
			if(temp.contains(subStr)) { //ƥ�䵽�˵�һ���Ӵ�
				temp.remove(subStr);
				for(int j = i + len;j <= S.length() - len;j = j + len) { //�жϴ������������ܲ���ƥ�������е��Ӵ�
					subStr = S.substring(j, j + len);
					if(temp.contains(subStr)) {
						temp.remove(subStr);
					}
					else 
						break;
				}
				if(temp.isEmpty()) //ƥ�����ˣ��������ʼλ�ü���
					res.add(i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String S = "a";
		String[] L = {"a"};
		System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(S, L));
	}
	
}
