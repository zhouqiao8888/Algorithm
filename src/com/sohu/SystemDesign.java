package com.sohu;
import java.util.*;
/*搜狐已经累计拥有千万级别会员用户，会员成长值公式为：会员成长值=每天成长值+任务成长值。
 *输入一组数组，第一行是n，表示接下来有n行数据输入，
 *从第二行开始，如果第一个是1，则该行有4个数据，
 *第一个1表示每日成长规则，第二个数字表示开始时间，第三个数字表示截止时间，第四个数字表示每日成长值。
 *如果第一个数字是2，则该行总共有3个数字，第二个数字表示某一天做任务，第三个数字表示任务成长值。
 *每日总的成长值=每日成长值+任务成长值；若每日成长值有多个，以最大的那个值为准。例如：
  3
  1 1 5 10
  2 3 4
  1 4 6 -5
输出49
 */
public class SystemDesign {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i < n;i ++) {
			int flag = s.nextInt();	//标识位，为1表示每天成长值，为2表示任务成长值
			if(flag == 1) {
				int start = s.nextInt();
				int end = s.nextInt();
				int base = s.nextInt();
				for(int j = start;j <= end;j ++) {
					if(map.containsKey(j)) {
						int value = map.get(j);
						if(base > value) {	//若每日成长值有多个，以最大的那个值为准
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
				int addValue = s.nextInt();	//任务成长值直接叠加
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
		//求和
		for(int i : map.values()) {
			sum += i;
		}
		System.out.println(sum);
	}
}
