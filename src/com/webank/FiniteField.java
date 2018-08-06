package com.webank;
/*���������⣺
 *��n�ķ�Χ�ڣ�ĳһ����������������������k�η�(������k�η���һ����������)��
 *����Ϊ����Ҫ�����������������ĸ��������統n=37ʱ������Ҫ�������19����
 *2��3��4��5��7��8��9��11��13��16��17��19��23��25��27��29��31��32��37��
*/
import java.util.Scanner;
public class FiniteField {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int flag[] = new int[n + 1];	//��ʶ���飬���ĳһ�����Ѿ��жϹ��������ˣ����´β������ж�
			int count = 0;
			for(int j = 2; j <= n; j ++){
				if(flag[j] == 1) 
					continue;
				if(isPrime(j)){
					flag[j] = 1;
					count ++;
					int base = j;
					while(base * j <= n){	//������k�η�Ҳ������Ҫ���
						base = base * j;
						flag[base] = 1;
						count ++;
					}
				}
			}
			System.out.println(count);
		}
	}
	//�ж�һ�����Ƿ�������
	public static boolean isPrime(int number){  
	    if(number == 2) 
	    	return true;
	    if(number < 2 || number % 2 == 0) //ż���϶���������(����2),������һ��������(����9),�����϶���3,5,7,,
	    	return false; 		
	    for(int j = 3;j <= Math.sqrt(number);j += 2){ //�����Ѿ�����2�ı�����,����������4,6,8,,�ı���,����j += 2 
	        if(number % j == 0){
	            return false;  
	        }  
	    }  
	    return true;  
	}  
}

