package com.wuyao;
/*
 * һ�Ѻ졢�̡���������ɫ���򣬰��պ�������˳���������
 */
import java.util.Scanner;
public class RGBSort{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
	        StringBuilder sb = new StringBuilder(s.next());
	        int pr = 0; //��¼�����ָ��
			int pg = 0;	//��¼�����ָ��,��ǰָ��
			int pb = sb.length() - 1; //��¼�����ָ��
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
					swap(sb, pg, pb);	//����ط�ֻ��pb--����û��pg++��
					pb --;				//����Ϊ��pg��pb��������pgָ����п����Ǻ������Բ���pg++��Ҫ�ȴ���һ���ж�					
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

