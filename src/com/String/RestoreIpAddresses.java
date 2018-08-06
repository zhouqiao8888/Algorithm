package com.String;

import java.util.ArrayList;

/*给出一个数字字符串，找出它能组合成的所有ip地址
 *例如String str = "25525511135",组合为["255.255.11.135", "255.255.111.35"]. 
 *注：分成4段，关键点是每一段范围是0-255且每一段最大长度是3，最后拼起来的长度要和str的长度相等，允许第一段为0
 */
public class RestoreIpAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if(s == null)
			return res;
		for(int i = 1;i < s.length() - 2 && i < 4;i ++) {	//注意第一段、第二段、第三段末尾范围
			for(int j = i + 1;j < s.length() - 1 && j < i + 4;j ++) {
				for(int k = j + 1;k < s.length() && k < j + 4;k ++) {
					if(s.length() - k > 3) { //控制最后一段的长度不能超过3
						continue;
					}
					int s1 = Integer.parseInt(s.substring(0, i)); 
					int s2 = Integer.parseInt(s.substring(i, j)); 
					int s3 = Integer.parseInt(s.substring(j, k)); 
					int s4 = Integer.parseInt(s.substring(k)); 
					if(s1 > 255 || s2 > 255 || s3 > 255 || s4 > 255)
						continue;
					String str = s1 + "." + s2 + "." + s3 + "." + s4;
					//验证s是否全部用完
					if(str.length() - 3 != s.length())
						continue;
					res.add(str);
				}
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		String str = "0123";
		System.out.println(new RestoreIpAddresses().restoreIpAddresses(str));
	}
}
