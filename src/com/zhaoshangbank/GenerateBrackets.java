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
	 
	 /*当前位置可以放(，但是能不能放)就要看到目前为止放了多少个)，如果(的个数比)多，那么当前位置就可以放)
	  *这是因为括号的放置是先左后右的，不可能出现)，())
	  */
     public void getgenerateParentList(ArrayList<String> res, String item, int n, int lge, int rge) {  
	       if(lge == n){  //左括号满时，就只能放右括号
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
