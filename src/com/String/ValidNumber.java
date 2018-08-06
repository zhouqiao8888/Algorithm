package com.String;
public class ValidNumber {
	public boolean isNumber(String s) {
        try {
            char c = s.charAt(s.length() - 1);
            if(c == 'f' || c == 'F' || c == 'd' || c == 'D') { //ͨ���ж����һ���ַ������ǲ���float�ͻ���double��
            	//System.out.println(c);
            	return false;
            }
            Double d = Double.valueOf(s); //����ͷ���false
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
