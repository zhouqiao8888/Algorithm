package com.String;
import java.util.ArrayList;
/*
 * 给定一个字符串数组和每行的长度，按要求编辑成文本行的形式
 * ["This", "is", "an", "example", "of", "text", "justification."] 16
 * [
   "This    is    an",
   "example  of text",
   "justification.  "
   ]
如上所示：每一行存放的单词个数尽可能多，但是总的字符个数（包括空格）不能超过16，
当单词间的空格个数不能保证全部是偶数的时候，优先左边空格；例如8个字符，3个间距，按3 3 2分布
最后一行特别处理：间距默认为1个空格，最后凑不够16的字符，全部用空格代替
注：本题十分繁琐，要小心处理
 */
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> res = new  ArrayList<String>();
		if(words == null || words.length <= 0 || L <= 0) {
			res.add("");
			return res;
		}		
		int start = 0;
		while(start < words.length) {
			StringBuilder sb = new StringBuilder();
			//统计每一行应放的单词个数
			int end = start + 1; //尾指针
			int len = words[start].length();
			while(end < words.length && len + 1 + words[end].length() <= L) { //以间距空格数为1计算，每行能放得下的最大单词数
				len += 1 + words[end].length();
				end ++;
			}
			//是最后一行
			if(end == words.length) {
				sb.append(words[start]);
				for(int i = start + 1;i < words.length;i ++) {
					sb.append(" " + words[i]);
				}
				while(sb.length() < L) {
					sb.append(" ");
				}
			}
			else { //不是最后一行
				end = end - 1;
				if(end - start == 0) { //不需要间距，长度为1
					sb.append(words[start]);
					while(sb.length() < L) {
						sb.append(" ");
					}
				}
				else {	//需要间距
					int blankCount = end - start;  //间距的个数
					int blankSumlen = L - (len - blankCount); //间距的总长度，要把原先加上的默认间距长度减掉
					int blankLen = 0; //每个间距的标准长度
					int blankAddLenCount = 0;  //前blankAddLenCount个间距长度要加1
					if(blankSumlen % blankCount == 0) {
						blankLen = blankSumlen / blankCount;
					}
					else {
						blankLen = blankSumlen / blankCount;
						blankAddLenCount = blankSumlen % blankCount;
					}
					//合成字符串
					for(int i = start;i < end;i ++) {
						sb.append(words[i]);
						if(blankAddLenCount != 0) {
							int blankLenTemp = blankLen + 1;
							for(int j = 0;j < blankLenTemp;j ++) {
								sb.append(" ");
							}
							blankAddLenCount --;
						}
						else {
							for(int j = 0;j < blankLen;j ++) {
								sb.append(" ");
							}
						}
					}
					sb.append(words[end]);
				}
			}
			res.add(sb.toString());
			start = end + 1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words2 = {"Listen","to ","many, ","speak ","to a","few. "};
		ArrayList<String> res = new TextJustification().fullJustify(words2, 6);
		for(String str : res) {
			System.out.println(str + "/"+ str.length());
		}
	}
}
