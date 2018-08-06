package com.Array;
import java.util.ArrayList;
import java.util.Collections;
/*
 * ����[1,2,,,n]����n!��ȫ���У�����n��k�����������еĵ�k�������磺
 * ����n=3������"123"�� "132" ��"213" ��"231" ��"312" ��"321" 
k=1������123
 */
public class PermutationSequence {
	//�ҹ��ɣ�����ʱ
	public String getPermutation(int n, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    for(int i = 0;i < n;i ++)
	        list.add(i + 1);
        int[] f = new int[n];
        f[0]=1;
        k --;
    	String res = "";
        for(int i = 1;i < n;i ++) //����׳�
        	f[i] = f[i - 1] * i;
        for(int i = n;i >= 1;i --){
            int j = k / f[i - 1];
            k = k % f[i - 1];
            res += list.get(j);
            //System.out.println("j:" + j + " k:" + k);
            list.remove(j);
        }
        return res;
	}
	
	//������������ʱ
	public String getPermutation2(int n, int k) {
		if(n <= 0 || k <= 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i <= n;i ++) {
			sb.append(i);
		}
		if(k == 1)
			return sb.toString();
		
		ArrayList<String> strList = new ArrayList<String>();
		String str = sb.toString();
		strList.add(str);
		for(int index = 0;index < str.length() - 1;index ++) {	//�ܹ�ѭ���Ĵ���
			int size = strList.size();
			for(int i = 0;i < size;i ++) {	 //ע������ط�����д��i < strList.size(),��Ϊһ��ѭ������strList��size�����
				String strTemp = strList.get(i);
				addStr(strList, strTemp, index);
			} 
		}		 
		Collections.sort(strList);	
		//System.out.println(strList);
		if(k > strList.size())
			return null;
		else 
			return strList.get(k - 1);
	}
	
	//���±겻Ϊindex���ַ����±���index���ַ�����
	public void addStr(ArrayList<String> strList, String str, int index) {	 
		for(int i = index + 1;i < str.length();i ++) {
			StringBuffer sb = new StringBuffer(str);
			char c = sb.charAt(index);
			sb.setCharAt(index, sb.charAt(i));
			sb.setCharAt(i, c);
			if(!strList.contains(sb.toString())) {
				strList.add(sb.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(3, 3));
	}
}
