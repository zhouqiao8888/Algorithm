package com.zhaoshangbank;
import java.util.*;
public class GenerateBrackets {
	 public ArrayList<String> generateParenthesis(int n) {   
          ArrayList<String> res = new ArrayList<String>();  
          if(n <= 0)	return res;
          String item = new String();  
          getgenerateParentList(res, item, n, 0, 0);  
          return res;  
     }  
	 
	 /*��ǰλ�ÿ��Է�(�������ܲ��ܷ�)��Ҫ����ĿǰΪֹ���˶��ٸ�)�����(�ĸ�����)�࣬��ô��ǰλ�þͿ��Է�)
	  *������Ϊ���ŵķ�����������ҵģ������ܳ���)��())
	  */
     public void getgenerateParentList(ArrayList<String> res, String item, int n, int lge, int rge) {  
	       if(lge == n){  //��������ʱ����ֻ�ܷ�������
	            for(int i = 0;i < n - rge;i ++){  
	                 item += ")";  
	            }  
	            res.add(new String(item));  
	            return;  
	       }  
	       getgenerateParentList(res, item + "(", n, lge + 1, rge);  
	       if(lge > rge){  
	            getgenerateParentList(res, item + ")", n, lge, rge + 1);                     
	       }  
    }  
     
    public static void main(String[] args) {
    	GenerateBrackets gp = new GenerateBrackets();
    	ArrayList<String> list = gp.generateParenthesis(3);
    	for(String i : list) {
    		System.out.println(i);
    	}
	}
}
