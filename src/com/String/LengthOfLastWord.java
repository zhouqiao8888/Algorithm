package com.String;
/*字符串由空格和单词组成，返回字符串中最后一个单词的长度
 *如果最后一个单词不存在，返回0
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
