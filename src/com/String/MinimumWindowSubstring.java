package com.String;
/*
 * ���������ַ���S��T���ҵ�S����T�������ַ�����С�������ڣ�����
 * S ="ADOBECODEBANC"
   T ="ABC"
   ��С��������Ϊ��BANC 
 ע��������ѣ�Ҫע�����
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if(S == null || S.length() <= 0 || T == null || T.length() <= 0) {
			return "";
		}
		//ͳ��T�и����ַ��ĸ���
		int[] map = new int[256];
		for(int i = 0;i < T.length();i ++) {
			map[T.charAt(i)] ++;
		}
		int start = 0; //�������
		int end = 0; //�����յ�
		int count = T.length(); //T�д�ƥ����ַ�����
		int begin = start; //��ƥ��ʱ����¼��ʱ���ڵ����
		int d = Integer.MAX_VALUE;	//��ƥ��ʱ����¼���ڵĳ���
		while(end < S.length()) {
			if(map[S.charAt(end ++)] -- > 0) {  //�����Ƿ�ƥ�䣬βָ��end��Ҫ��1������map�е��ַ�ͳ�ƴ�����Ҫ��1����ƥ��Ϊ����ƥ���1��
				count --; //��S���ַ�ƥ�䵽T�е��ַ�ʱ����ƥ����ַ�������1
			}
			while(count == 0) { //�����һ��ƥ��
				if(end - start < d) { //����d��ͬʱ��¼��ʱ���ڵ����
					d = end - start;
					begin = start;
				}
				if(map[S.charAt(start ++)] ++ == 0) { //�����һ��ƥ���ͷָ���1��Ѱ����һ��ƥ�䣬����Щ�ַ����Ƴ���֮���൱��ԭ�ȵ�ƥ�䶼ʧЧ�ˣ���˶�Ӧ��map�۵���ֵ��Ҫ��1
					count ++;  //�����������Ϊ0���ַ���˵�����ַ���ǰ�����ƥ�䣬����ָ�����ƣ����ַ����Ƴ����ڣ����ƥ����ַ�����Ҫ��1
				}
			}
		}
		return d == Integer.MAX_VALUE ? "" : S.substring(begin, begin + d);
	}
	
	public static void main(String[] args) {
		String S = "ab";
		String T = "a";
		System.out.println(new MinimumWindowSubstring().minWindow(S, T));
	}
}
