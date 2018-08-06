package com.String;
public class ValidNumber {
	public boolean isNumber(String s) {
        try {
            char c = s.charAt(s.length() - 1);
            if(c == 'f' || c == 'F' || c == 'd' || c == 'D') { //通过判断最后一个字符，看是不是float型或者double型
            	//System.out.println(c);
            	return false;
            }
            Double d = Double.valueOf(s); //报错就返回false
            //System.out.println(d);
            return true;
        } catch (NumberFormatException e) {
            return false;  
        }
	}

	public static void main(String[] args) {
		String str = "959440.94f";
		System.out.println(new ValidNumber().isNumber(str));
	}
}
