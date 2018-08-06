package com.String;

import java.util.ArrayList;

/*����һ�������ַ������ҳ�������ϳɵ�����ip��ַ
 *����String str = "25525511135",���Ϊ["255.255.11.135", "255.255.111.35"]. 
 *ע���ֳ�4�Σ��ؼ�����ÿһ�η�Χ��0-255��ÿһ����󳤶���3�����ƴ�����ĳ���Ҫ��str�ĳ�����ȣ������һ��Ϊ0
 */
public class RestoreIpAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if(s == null)
			return res;
		for(int i = 1;i < s.length() - 2 && i < 4;i ++) {	//ע���һ�Ρ��ڶ��Ρ�������ĩβ��Χ
			for(int j = i + 1;j < s.length() - 1 && j < i + 4;j ++) {
				for(int k = j + 1;k < s.length() && k < j + 4;k ++) {
					if(s.length() - k > 3) { //�������һ�εĳ��Ȳ��ܳ���3
						continue;
					}
					int s1 = Integer.parseInt(s.substring(0, i)); 
					int s2 = Integer.parseInt(s.substring(i, j)); 
					int s3 = Integer.parseInt(s.substring(j, k)); 
					int s4 = Integer.parseInt(s.substring(k)); 
					if(s1 > 255 || s2 > 255 || s3 > 255 || s4 > 255)
						continue;
					String str = s1 + "." + s2 + "." + s3 + "." + s4;
					//��֤s�Ƿ�ȫ������
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
