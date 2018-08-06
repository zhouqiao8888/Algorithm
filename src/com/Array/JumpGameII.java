package com.Array;
/*
 * ����һ���Ǹ����飬�����е�ÿ��Ԫ�ر�ʾ��Ԫ�ؿ�����Ծ����󳤶ȣ�
 * ����Ծ���������һ��Ԫ���������С������������0���������֤�ǿ�����Ծ��
 * ���磺��������A = [2,3,1,1,4]����С������2
 * ˼·����һ���ڵ����Ҫ���룬ÿ�ν���һ�����i֮��
 * ��һ������������[i+1, i+nums[i]]���ҵ������Χ�ڵĿ�����Ծ��Զ�ĵ���Ϊ��һ����
 * ѭ��ֱ����Ծ�����
 * ע�⣺��Ծ��Զ�����������йأ�������Ծ�ĳ���
 */
public class JumpGameII {
	public int jump(int[] A) {
        if(A.length <= 0 || A == null)
        	return 0;
        int i = 0;
        int count = 0;
        int len = A.length;
        while(i < len - 1) {  
        	count ++;
        	int p1 = i + 1;
        	int p2 = i + A[i];
        	if(p2 >= len - 1)	//������Ծ��Χ���������鳤�ȣ�ֱ������ѭ��
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
        return count;
    }
	
	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		int[] A = {2,3,1,1,4};
		System.out.println(jg.jump(A));
	}

}
