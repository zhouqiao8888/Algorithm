package com.String;
/*�ַ����ɿո�͵�����ɣ������ַ��������һ�����ʵĳ���
 *������һ�����ʲ����ڣ�����0
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		if(s == null || s.length() <= 0)
			return 0;
		String[] arr = s.split(" ");
		return arr[arr.length - 1].length();
	}
	
	public static void main(String[] args) {
		String s = " ";
		System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
	}
}
