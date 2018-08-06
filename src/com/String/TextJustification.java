package com.String;
import java.util.ArrayList;
/*
 * ����һ���ַ��������ÿ�еĳ��ȣ���Ҫ��༭���ı��е���ʽ
 * ["This", "is", "an", "example", "of", "text", "justification."] 16
 * [
   "This    is    an",
   "example  of text",
   "justification.  "
   ]
������ʾ��ÿһ�д�ŵĵ��ʸ��������ܶ࣬�����ܵ��ַ������������ո񣩲��ܳ���16��
�����ʼ�Ŀո�������ܱ�֤ȫ����ż����ʱ��������߿ո�����8���ַ���3����࣬��3 3 2�ֲ�
���һ���ر������Ĭ��Ϊ1���ո����ղ���16���ַ���ȫ���ÿո����
ע������ʮ�ַ�����ҪС�Ĵ���
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
			//ͳ��ÿһ��Ӧ�ŵĵ��ʸ���
			int end = start + 1; //βָ��
			int len = words[start].length();
			while(end < words.length && len + 1 + words[end].length() <= L) { //�Լ��ո���Ϊ1���㣬ÿ���ܷŵ��µ���󵥴���
				len += 1 + words[end].length();
				end ++;
			}
			//�����һ��
			if(end == words.length) {
				sb.append(words[start]);
				for(int i = start + 1;i < words.length;i ++) {
					sb.append(" " + words[i]);
				}
				while(sb.length() < L) {
					sb.append(" ");
				}
			}
			else { //�������һ��
				end = end - 1;
				if(end - start == 0) { //����Ҫ��࣬����Ϊ1
					sb.append(words[start]);
					while(sb.length() < L) {
						sb.append(" ");
					}
				}
				else {	//��Ҫ���
					int blankCount = end - start;  //���ĸ���
					int blankSumlen = L - (len - blankCount); //�����ܳ��ȣ�Ҫ��ԭ�ȼ��ϵ�Ĭ�ϼ�೤�ȼ���
					int blankLen = 0; //ÿ�����ı�׼����
					int blankAddLenCount = 0;  //ǰblankAddLenCount����೤��Ҫ��1
					if(blankSumlen % blankCount == 0) {
						blankLen = blankSumlen / blankCount;
					}
					else {
						blankLen = blankSumlen / blankCount;
						blankAddLenCount = blankSumlen % blankCount;
					}
					//�ϳ��ַ���
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
