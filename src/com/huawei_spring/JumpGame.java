package com.huawei_spring;
import java.util.*;
/*
 * ����һ������������ӵ�һ���������һ����������Ծ��ÿ��������Ծ1��
 * ÿ������ֵ��ʾ������λ�ÿ�����Ծ����󳤶ȡ�������������ٵ���Ծ�����������һ������  
 */
public class JumpGame{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
	        int len = s.nextInt();
	        int A[] = new int[len];
	        for(int j = 0; j < len; j ++){
	            A[j] = s.nextInt();
	        }
	        int i = 0;
	        int count = 0;
	        while(i < len - 1) {  
	        	count ++;
	        	int p1 = i + 1;		//��ǰ����Ծ�����
	        	int p2 = i + A[i];	//��ǰ����Ծ���յ�
	        	if(p2 >= len - 1)	//�յ㳬�������鳤�ȣ�ֱ������ѭ��
	        		break;    
	        	//Ѱ�����䷶Χ�ڿ�����Զ�����Ԫ���±�
	    		int max = p1 + A[p1];
	    		int maxIndex = p1;
	    		for(int j = p1 + 1;j <= p2 && j < len;j ++) {
	    			int temp = j + A[j];
	    			if(temp > max) {
	    				max = temp;
	    				maxIndex = j;
	    			}
	    		}
	    		i = maxIndex;
	        }
	        System.out.println(count);
        }
    }
}

