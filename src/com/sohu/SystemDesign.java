package com.sohu;
import java.util.*;
/*�Ѻ��Ѿ��ۼ�ӵ��ǧ�򼶱��Ա�û�����Ա�ɳ�ֵ��ʽΪ����Ա�ɳ�ֵ=ÿ��ɳ�ֵ+����ɳ�ֵ��
 *����һ�����飬��һ����n����ʾ��������n���������룬
 *�ӵڶ��п�ʼ�������һ����1���������4�����ݣ�
 *��һ��1��ʾÿ�ճɳ����򣬵ڶ������ֱ�ʾ��ʼʱ�䣬���������ֱ�ʾ��ֹʱ�䣬���ĸ����ֱ�ʾÿ�ճɳ�ֵ��
 *�����һ��������2��������ܹ���3�����֣��ڶ������ֱ�ʾĳһ�������񣬵��������ֱ�ʾ����ɳ�ֵ��
 *ÿ���ܵĳɳ�ֵ=ÿ�ճɳ�ֵ+����ɳ�ֵ����ÿ�ճɳ�ֵ�ж�����������Ǹ�ֵΪ׼�����磺
  3
  1 1 5 10
  2 3 4
  1 4 6 -5
���49
 */
public class SystemDesign {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i < n;i ++) {
			int flag = s.nextInt();	//��ʶλ��Ϊ1��ʾÿ��ɳ�ֵ��Ϊ2��ʾ����ɳ�ֵ
			if(flag == 1) {
				int start = s.nextInt();
				int end = s.nextInt();
				int base = s.nextInt();
				for(int j = start;j <= end;j ++) {
					if(map.containsKey(j)) {
						int value = map.get(j);
						if(base > value) {	//��ÿ�ճɳ�ֵ�ж�����������Ǹ�ֵΪ׼
							map.put(j, base);
						}
					}
					else {
						map.put(j, base);
					}				    			    
				}
			}
			if(flag == 2) {
				int key = s.nextInt();
				int addValue = s.nextInt();	//����ɳ�ֱֵ�ӵ���
				if(map.containsKey(key)) {
					int value = map.get(key);
					value += addValue;
					map.put(key, value);
				}
				else {
					map.put(key, addValue);
				}
			}
		}
		//���
		for(int i : map.values()) {
			sum += i;
		}
		System.out.println(sum);
	}
}
