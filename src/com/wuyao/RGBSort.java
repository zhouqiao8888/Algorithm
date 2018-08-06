package com.wuyao;
/*
 * 一堆红、绿、蓝三种颜色的球，按照红绿蓝的顺序进行排序
 */
import java.util.Scanner;
public class RGBSort{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
	        StringBuilder sb = new StringBuilder(s.next());
	        int pr = 0; //记录红球的指针
			int pg = 0;	//记录绿球的指针,当前指针
			int pb = sb.length() - 1; //记录蓝球的指针
			while(pg <= pb) {
				if(sb.charAt(pg) == 'R') {
					swap(sb, pr, pg);
					pr ++;
					pg ++;
				}
				else if(sb.charAt(pg) == 'G') {
					pg ++;
				}
				else {
					swap(sb, pg, pb);	//这个地方只有pb--，而没有pg++，
					pb --;				//是因为，pg、pb交换过后，pg指向的有可能是红球，所以不能pg++，要等待下一次判断					
				}
			}
			System.out.println(sb.toString());
        }
    }
    
    public static void swap(StringBuilder sb, int p1, int p2) {
		char c = sb.charAt(p1);
		sb.setCharAt(p1, sb.charAt(p2));
		sb.setCharAt(p2, c);
	}
}

