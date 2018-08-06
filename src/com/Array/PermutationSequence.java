package com.Array;
import java.util.ArrayList;
import java.util.Collections;
/*
 * 集合[1,2,,,n]共有n!种全排列，给定n和k，返回排列中的第k个，例如：
 * 给定n=3，共有"123"、 "132" 、"213" 、"231" 、"312" 、"321" 
k=1，返回123
 */
public class PermutationSequence {
	//找规律，不超时
	public String getPermutation(int n, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    for(int i = 0;i < n;i ++)
	        list.add(i + 1);
        int[] f = new int[n];
        f[0]=1;
        k --;
    	String res = "";
        for(int i = 1;i < n;i ++) //构造阶乘
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
	
	//暴力搜索，超时
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
		for(int index = 0;index < str.length() - 1;index ++) {	//总共循环的次数
			int size = strList.size();
			for(int i = 0;i < size;i ++) {	 //注：这个地方不能写成i < strList.size(),因为一次循环过后strList的size变大了
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
	
	//将下标不为index的字符和下标是index的字符交换
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
